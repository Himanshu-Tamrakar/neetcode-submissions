class Edge implements Comparable<Edge> {
        int v, w, weight;
        public Edge(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        public int either() {
            return this.v;
        }

        public int other(int v) {
            if (this.v == v) return this.w;
            else return this.v;
        }

        public int weight() {
            return this.weight;
        }

        public String toString() {
            return this.v + " -> " + this.w + " " + this.weight;
        }

        @Override
        public int compareTo(Edge that) {
            return Integer.compare(this.weight, that.weight);
        }
    }

class EdgeWeightedGraph {
        private int V;
        private int E;
        private List<Edge>[] adj;
        public EdgeWeightedGraph(int V) {
            if (V < 0) throw new IllegalArgumentException("");
            this.V = V;
            this.E = 0;
            this.adj = new ArrayList[V];
            for(int v = 0; v < V; v++) {
                this.adj[v] = new ArrayList<>();
            }

        }

        public int V() {return this.V;}
        public int E() {return this.E;}

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

class UF {
    private int[] pq;
    private int[] sz;
    private int count;

    public UF(int V) {
        pq = new int[V];
        sz = new int[V];
        count = V;
        for (int i = 0; i < V; i++) {
            pq[i] = i;
            sz[i] = 1;
        }
    }

    private int find(int p) {
        int root = p;
        while (root != pq[root])
            root = pq[root];
        while (p != root) {
            int newp = pq[p];
            pq[p] = root;
            p = newp;
        }
        return root;

    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // make smaller root point to larger one
        if (sz[rootP] < sz[rootQ]) {
            pq[rootP] = rootQ;
            sz[rootQ] += sz[rootP];
        } else {
            pq[rootQ] = rootP;
            sz[rootP] += sz[rootQ];
        }
        count--;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int connectedComponents() {
        return count;
    }
}
class Solution {
    
    private PriorityQueue<Edge> pq;
    private UF uf;
    private List<Edge> mst;
    private boolean[] marked;
    EdgeWeightedGraph graph;
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        graph = new EdgeWeightedGraph(n);
        pq = new PriorityQueue<>();
        uf = new UF(n);
        mst = new ArrayList<>();
        marked = new boolean[n];
        for (List<Integer> edge: edges)  {
            int v = edge.get(0);
            int w = edge.get(1);
            int weight = edge.get(2);
            Edge e = new Edge(v, w, weight);
            graph.addEdge(e);
        }
        
        visit(0); 

        while(!pq.isEmpty() && mst.size() < n-1) {
            Edge e = pq.remove();
            int v = e.either();
            int w = e.other(v);
            if (uf.connected(v, w)) continue;
            mst.add(e);
            uf.union(v, w);
            if (!marked[v]) visit(v);
            if(!marked[w]) visit(w);
        }     

        if (uf.connectedComponents() > 1)  return -1;

        int res = 0;
        for (Edge e: mst) {
            res += e.weight();
        }
        return res;
        
    }   

    private void visit(int v) {
        marked[v] = true;

        for (Edge e: graph.adj(v)) {
            pq.offer(e);
        }

    }
}    
