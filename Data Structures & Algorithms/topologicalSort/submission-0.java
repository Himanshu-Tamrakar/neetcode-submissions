class Digraph {
    private int V;
    private int E;
    private List<Integer>[] adj;
    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new ArrayList[V];
        for(int v = 0; v < V; v++) {
            this.adj[v] = new ArrayList<>();
        }
    }
    public int V() {
        return this.V;
    }
    public Iterable<Integer> adj(int v) {
        return this.adj[v];
    }
    public void addEdge(int v, int w) {
        this.adj[v].add(w);
        this.E++;
    }
}
class Solution {
    private Digraph graph;
    private boolean[] visiting;
    private boolean[] visited;
    private boolean isCycle;
    private List<Integer> topological;
    private Deque<Integer> stack;

    public List<Integer> topologicalSort(int n, int[][] edges) {
        graph = new Digraph(n);
        visiting = new boolean[n];
        visited = new boolean[n];
        isCycle = false;
        stack = new ArrayDeque<>();
        topological = new ArrayList<>();
        for(int[] edge: edges) {
            int v = edge[0];
            int w = edge[1];
            graph.addEdge(v, w);
        }

        for (int v = 0; v < graph.V(); v++) {
            if (!visited[v]) dfs(v);
        }

        if (isCycle) {
            topological = new ArrayList<>();
            return topological;
        }

        for (int v: stack) { 
            topological.add(v);
        }
        
        return topological;
    }

    private void dfs(int v) {
        visiting[v] = true;
        visited[v] = true;

        for (int w: graph.adj(v)) {
            if (isCycle) break;
            if (visiting[w]) isCycle = true;
            
            if (!visited[w]) dfs(w);
        }
        stack.push(v);
        visiting[v] = false;
    }

 

}
