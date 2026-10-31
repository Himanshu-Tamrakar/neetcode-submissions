

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int v = 0; v < numCourses; v++) {
            adj.put(v, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int v = prerequisite[0];
            int u = prerequisite[1];
            adj.get(u).add(v);
        }

        
        Map<Integer, Set<Integer>> indirect = new HashMap<>();
        for (int v = 0; v < numCourses; v++) {
            indirect.put(v, new HashSet<>());
        }

        // Step 3: Run DFS from every node to find all its dependencies/reachability
        boolean[] visited = new boolean[numCourses];
        for (int v = 0; v < numCourses; v++) {
            dfs(v, adj, indirect, visited);
        }

        // Step 4: Answer the queries
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            int v = query[0];
            int u = query[1];
            // Check if u is reachable from v
            result.add(indirect.get(u).contains(v));
        }

        return result;
    }

    private void dfs(int v, Map<Integer, List<Integer>> adj, Map<Integer, Set<Integer>> indirect, boolean[] visited) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;

        for (int w : adj.get(v)) {
            // First, process the w completely
            dfs(w, adj, indirect, visited);
            
            // The w itself is reachable from v
            indirect.get(v).add(w);
            
            // Everything reachable from the w is also reachable from v
            indirect.get(v).addAll(indirect.get(w));
        }
    }
}
