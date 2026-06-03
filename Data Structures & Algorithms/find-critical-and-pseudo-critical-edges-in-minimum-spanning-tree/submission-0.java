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

class EdgeWeightedGraph {
    private int V;
    private int E;
    private List<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new ArrayList[V];
        for (int v = 0; v < V; v++) {
            this.adj[v] = new ArrayList<>();
        }
    }
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        this.adj[v].add(e);
        this.adj[w].add(e);
        this.E++;
    }
    public Iterable<Edge> adj(int v) {
        return this.adj[v];
    }
}

class Solution {
    private PriorityQueue<Edge> pq;
    private EdgeWeightedGraph graph;
    private List<Edge> mst;
    private UF uf;
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        pq = new PriorityQueue<>();
        
        mst = new ArrayList<>();
        uf = new UF(n);

        for (int i = 0; i < edges.length; i++)  {
            int[] edge = edges[i];
            int v = edge[0];
            int w = edge[1];
            int weight = edge[2];

            Edge e = new Edge(v, w, weight, i);
            pq.offer(e);
            
        }

        int mstWeight = 0;
        // Krushkal Algo to find mst
        while (!pq.isEmpty() && mst.size() < n-1) {
            Edge e = pq.remove();
            int v = e.either();
            int w = e.other(v);
            if (uf.connected(v, w)) continue;
            uf.union(v, w);
            mstWeight += e.weight();
            mst.add(e);
        }

        List<Integer> criticalEdge = new ArrayList<>();
        List<Integer> pseudoCriticalEdge = new ArrayList<>();

        for (int j = 0; j < edges.length; j++) {
            Edge e = new Edge(edges[j][0], edges[j][1], edges[j][2], j);
            // Try for critical Edge
            pq = new PriorityQueue<>();
            uf = new UF(n);

            for (int i = 0; i < edges.length; i++) {
                if (e.index == i) continue;

                int[] edge = edges[i];
                int v = edge[0];
                int w = edge[1];
                int weight = edge[2];
                Edge edge1 = new Edge(v, w, weight, i);
                pq.offer(edge1);
            }

            int mstWeightByEdgeIgnore = 0;
             // Krushkal Algo to find mst
            while (!pq.isEmpty()) {
                Edge edge = pq.remove();
                int v = edge.either();
                int w = edge.other(v);
                if (uf.connected(v, w)) continue;
                uf.union(v, w);
                mstWeightByEdgeIgnore += edge.weight();
                
            }

            if (uf.count() > 1 || mstWeightByEdgeIgnore > mstWeight) {
                criticalEdge.add(e.index);
                continue; // critical edge can not be pseudo creitical edge
            } 

            // Try for pseudo critical Edge
            pq = new PriorityQueue<>();
            uf = new UF(n);
            int mstWeightByEdgeInclude = e.weight();
            int v = e.either();
            int w = e.other(v);
            uf.union(v, w);

            for (int i = 0; i < edges.length; i++) {
                if (e.index == i) continue;

                int[] edge = edges[i];
                int v1 = edge[0];
                int w1 = edge[1];
                int weight1 = edge[2];
                Edge edge1 = new Edge(v1, w1, weight1, i);
                pq.offer(edge1);
            }

            
             // Krushkal Algo to find mst
            while (!pq.isEmpty()) {
                Edge edge = pq.remove();
                int v1 = edge.either();
                int w1 = edge.other(v1);
                if (uf.connected(v1, w1)) continue;
                uf.union(v1, w1);
                mstWeightByEdgeInclude += edge.weight();
            }

            if (mstWeightByEdgeInclude == mstWeight) {
                pseudoCriticalEdge.add(e.index);
            }

        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(criticalEdge);
        res.add(pseudoCriticalEdge);
        return res;
    }
}