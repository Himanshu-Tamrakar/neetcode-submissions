class Digraph {
    private int V;
    private int E;
    private List<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = (List<Integer>[]) new ArrayList[V];
        for (int v = 0; v < V; v++) {
            this.adj[v] = new ArrayList<>();
        }
    }
    public int V() {return this.V;}
    public int E() {return this.E;}
    public void addEdge(int v, int w) {
        adj[v].add(w);
        this.E++;
    }
    public Iterable<Integer> adj(int v) {
        return this.adj[v];
    }

}
class Solution {
    private Digraph graph;
    private boolean isCycle;
    private boolean[] marked;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new Digraph(numCourses);
        isCycle = false;
        marked = new boolean[numCourses];
        for(int[] prerequisite: prerequisites) {
            int v = prerequisite[1];
            int w = prerequisite[0];
            graph.addEdge(v, w);
        }

        for (int v = 0; v < graph.V(); v++) {
            if (!marked[v]) dfs(v);
        }

        return isCycle == false ? true : false;

    }

    private void dfs(int v) {
        marked[v] = true;

        for (int w: graph.adj(v)) {
            if (isCycle) break;
            if (marked[w]) this.isCycle = true;
            if (!marked[w]) dfs(w);
        }
        marked[v] = false;
    }
}
