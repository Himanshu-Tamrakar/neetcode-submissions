class Solution {
    private boolean hasCycle;
    public List<Integer> topologicalSort(int n, int[][] edges) {
        hasCycle = false;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge: edges) {
            adj.computeIfAbsent(edge[0], e -> new ArrayList<>()).add(edge[1]);
        }
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visit = new HashSet<>();
        List<Integer> postOrder = new ArrayList<>();
        for (int v = 0; v < n; v++) {
            if (!visit.contains(v)) {
                dfs(adj, v, visit, visiting, postOrder);
            }
        }
        if (this.hasCycle) {
            return Collections.emptyList();
        }

        Collections.reverse(postOrder);
        return postOrder;
    }

    private void dfs(Map<Integer, List<Integer>> adj, int v, Set<Integer> visit, Set<Integer> visiting, List<Integer> postOrder) {
        if (visit.contains(v)) {
            return;
        }

        visit.add(v);
        visiting.add(v);
        for (int w : adj.getOrDefault(v, Collections.emptyList())) {
            if (visiting.contains(w)) {
                this.hasCycle = true;
            }

            if (!this.hasCycle && !visit.contains(w)) {
                dfs(adj, w, visit, visiting, postOrder);
            }
        }
        visiting.remove(v);
        postOrder.add(v);
    }


}
