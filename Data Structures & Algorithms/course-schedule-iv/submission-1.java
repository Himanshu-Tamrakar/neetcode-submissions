class Digraph {
    private int V;
    private List<Integer>[] adj;
    public Digraph(int V) {
        this.V = V;
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
    }
}

class DirectedDFS {
    private boolean[] marked;
    public DirectedDFS(Digraph graph, int s) {
        marked = new boolean[graph.V()];
        dfs(graph, s);
    }

    private void dfs(Digraph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) dfs(graph, w);
        }   
    }

    public boolean marked(int v) {
        return marked[v];
    }
}

class Solution {
    private DirectedDFS[] tc;
    private Digraph graph;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        tc = new DirectedDFS[numCourses];
        graph = new Digraph(numCourses);
        for (int[] prerequisite: prerequisites) {
            int v = prerequisite[0];
            int w = prerequisite[1];
            graph.addEdge(v, w);
        }

        for (int v = 0; v < numCourses; v++) {
            tc[v] = new DirectedDFS(graph, v);
        }   

        List<Boolean> result = new ArrayList<>();
        for (int[] query: queries) {
            int v = query[0];
            int w = query[1];
            if (tc[v].marked(w)) result.add(true);
            else result.add(false);
        }

        return result;

    }

}