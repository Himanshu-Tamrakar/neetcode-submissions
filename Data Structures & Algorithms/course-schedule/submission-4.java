class Solution {
    
    private boolean hasCycle;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        hasCycle = false;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int v = 0; v < numCourses; v++) {
            adj.put(v, new ArrayList<>());
        }

        for (int[] prerequisite: prerequisites) {
            int v = prerequisite[1];
            int w = prerequisite[0];
            adj.get(v).add(w);
        }

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visit = new HashSet<>();
        for (int v = 0; v < numCourses; v++) {
            if (this.hasCycle) {
                return false;
            }

            if (!visit.contains(v)) {
                dfs(adj, v, visit, visiting);
            }
        }

        return !this.hasCycle;
    }

    private void dfs(Map<Integer, List<Integer>> adj, int v, Set<Integer> visit, Set<Integer> visiting) {

        if (visit.contains(v)) {
            return;
        }

        visit.add(v);
        visiting.add(v);
        for (int w: adj.get(v)) {
            if (visiting.contains(w)) {
                this.hasCycle = true;
            }

            if (!this.hasCycle && !visit.contains(w)) {
                dfs(adj, w, visit, visiting);
            }
        }
        visiting.remove(v);
    }


}
