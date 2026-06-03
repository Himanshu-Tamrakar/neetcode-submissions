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


class Solution {
    
    private PriorityQueue<Edge> pq;
    private int count;
    private List<Edge> mst;
    private boolean[] marked;
    EdgeWeightedGraph graph;
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        graph = new EdgeWeightedGraph(n);
        pq = new PriorityQueue<>();
        count = n;
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
            if (marked[v] && marked[w]) continue;
            mst.add(e);
            count--;
            if (!marked[v]) visit(v);
            if(!marked[w]) visit(w);
            
        }     

        if (count > 1)  return -1;

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
