
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

class Solution {
    private Digraph graph;
    private boolean[] visited;
    private boolean[] visiting;
    private boolean isCycle;
    private Deque<Integer> stack;
    private int[] topological;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new Digraph(numCourses);
        visited = new boolean[numCourses];
        visiting = new boolean[numCourses];
        isCycle = false;
        stack = new ArrayDeque<>();
        topological = new int[numCourses];
        for (int[] prerequisite: prerequisites) {
            int v = prerequisite[1];
            int w = prerequisite[0];
            graph.addEdge(v, w);
        }

        for (int v = 0; v < graph.V(); v++) {
            if (!visited[v]) dfs(v);
        }

        if (isCycle) {
            return new int[0];
        }

        int i = 0;
        while (stack.size() > 0) topological[i++] = stack.pop();
        return topological;
    }

    private void dfs(int v) {
        visited[v] = true;
        visiting[v] = true;
        for (int w: graph.adj(v)) {
            if (isCycle) break;
            if (visiting[w]) isCycle = true;
            if (!visited[w]) dfs(w);
        }
        visiting[v] = false;
        stack.push(v);
    }
}
