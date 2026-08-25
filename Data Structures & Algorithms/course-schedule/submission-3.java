class Solution {
    private HashMap<Integer, List<Integer>> digraph;
    private boolean[] marked;
    private boolean[] onStack;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.digraph = new HashMap<>();
        this.marked = new boolean[numCourses];
        this.onStack = new boolean[numCourses];
        for (int v = 0; v < numCourses; v++) {
            digraph.put(v, new ArrayList<>());
        }

        for (int[] edge: prerequisites) {
            int v = edge[1];
            int w = edge[0];
            digraph.get(v).add(w);
        }

        for (int v = 0; v < numCourses; v++) {
            if (!marked[v] && isCycle(digraph, v)) {
                return false;
            }
        }

        return true;
    }

    private boolean isCycle(HashMap<Integer, List<Integer>> G, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (int w: G.get(v)) {
            if (onStack[w]) {
                return true;
            } else if (!marked[w] && isCycle(G, w)) {
                return true;
            }
        }
        onStack[v] = false;

        return false;
    }
}
