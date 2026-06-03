class UF {
    private int[] parent;
    private int[] size;
    private int count;
    public UF(int V) {
        this.parent = new int[V];
        this.size = new int[V];
        this.count = V;
        for (int v = 0; v < V; v++) {
            this.parent[v] = v;
            this.size[v] = 1;
        }
    }

    private int find(int p) {
        int root = p;
        while (root != this.parent[root]) root = parent[root];
        while (root != p) {
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
    private int v, w, weight;
    public Edge(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public int weight() {
        return this.weight;
    }
    public int either() {
        return this.v;
    }
    public int other(int v) {
        if (this.v == v) return w;
        return this.w;
    }

    @Override
    public int compareTo(Edge that) {
        return Integer.compare(this.weight, that.weight);
    }

    public String toString() {
        return this.v + " -> " + this.w + " " + this.weight;
    }
}

class Solution {
    private PriorityQueue<Edge> pq;
    private UF uf;
    private List<Edge> mst;
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        pq = new PriorityQueue<>();
        uf = new UF(n);
        mst = new ArrayList<>();
        for (List<Integer> edge: edges) {
            int v = edge.get(0);
            int w = edge.get(1);
            int weight = edge.get(2);
            Edge e = new Edge(v, w, weight);
            pq.offer(e);
        }
        
        int res = 0;

        while (!pq.isEmpty()) {
            Edge e = pq.remove();
            
            int v = e.either();
            int w = e.other(v);
            if (uf.connected(v, w)) continue;
            uf.union(v, w);
            res += e.weight();
            mst.add(e);
        }

        if (uf.count() == 1) return res;

        return -1;

    }
}
