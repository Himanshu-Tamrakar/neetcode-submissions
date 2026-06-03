class UF {
    private int[] parent;
    private int[] size;
    private int count;
    public UF(int N) {
        this.parent = new int[N];
        this.size = new int[N];
        this.count = N;
        for (int i = 0; i < N; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    private int find(int p) {
        int root = p;
        while (root != parent[root]) root = parent[root];
        while (p != root) {
            int newP = parent[p];
            parent[p] = root;
            p = newP;
        }
        return root;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }

    public int count() {
        return this.count;
    }
}
class Edge implements Comparable<Edge> {
    int v, w, weight, index;
    public Edge(int v, int w, int weight, int index) {
        this.v = v;
        this.w = w;
        this.weight = weight;
        this.index = index;
    }
    public int either() {
        return this.v;
    }
    public int other(int v) {
        if (this.v == v) return this.w;
        return this.v;
    }
    public int weight() {
        return this.weight;
    }
    @Override
    public int compareTo(Edge that) {
        return Integer.compare(this.weight, that.weight);
    }

    public String toString() {
        return  v + " -> " + w + "  " + weight;
    }
}

class Solution {
    private UF uf;
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        uf = new UF(n);
        Edge[] graphEdges = new Edge[edges.length];
        for (int i = 0; i < edges.length; i++) {
            graphEdges[i] = new Edge(edges[i][0], edges[i][1], edges[i][2], i);
        }

        Arrays.sort(graphEdges);

        int mstWeight = 0;
        // Krushkal Algo to find mst
        for (int i = 0; i < graphEdges.length; i++) {
            Edge e = graphEdges[i];
            int v = e.either();
            int w = e.other(v);
            if (uf.connected(v, w)) continue;
            uf.union(v, w);
            mstWeight += e.weight();
        }

        List<Integer> criticalEdge = new ArrayList<>();
        List<Integer> pseudoCriticalEdge = new ArrayList<>();

        for (int i = 0; i < graphEdges.length; i++) {
            Edge edge = graphEdges[i];
            // Try for critical Edge
            uf = new UF(n);

            int mstWeightByEdgeIgnore = 0;
             // Krushkal Algo to find mst
            for (int j = 0; j < graphEdges.length; j++) {
                if (graphEdges[j].index == edge.index) continue;

                Edge e = graphEdges[j];
                int v = e.either();
                int w = e.other(v);
                if (uf.connected(v, w)) continue;
                uf.union(v, w);
                mstWeightByEdgeIgnore += e.weight();
                
            }

            if (uf.count() > 1 || mstWeightByEdgeIgnore > mstWeight) {
                criticalEdge.add(edge.index);
                continue; // critical edge can not be pseudo creitical edge
            } 

            // Try for pseudo critical Edge
            uf = new UF(n);
            int mstWeightByEdgeInclude = edge.weight();
            int v1 = edge.either();
            int w1 = edge.other(v1);
            uf.union(v1, w1);
             // Krushkal Algo to find mst
            for (int j = 0; j < graphEdges.length; j++) {
                if (graphEdges[j].index == edge.index) continue;
                Edge e = graphEdges[j];
                int v = e.either();
                int w = e.other(v);
                if (uf.connected(v, w)) continue;
                uf.union(v, w);
                mstWeightByEdgeInclude += e.weight();
            }

            if (mstWeightByEdgeInclude == mstWeight) {
                pseudoCriticalEdge.add(edge.index);
            }

        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(criticalEdge);
        res.add(pseudoCriticalEdge);
        return res;
    }
}