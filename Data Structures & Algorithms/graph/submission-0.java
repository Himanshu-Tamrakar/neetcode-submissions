class Graph {
    HashMap<Integer, HashSet<Integer>> adj;
    public Graph() {
        adj = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        adj.putIfAbsent(src, new HashSet<>());
        adj.putIfAbsent(dst, new HashSet<>());

        adj.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if (!adj.containsKey(src) || !adj.get(src).contains(dst)) {
            return false;
        }
        adj.get(src).remove(dst);
        return true;
    }

    public boolean hasPath(int src, int dst) {
        HashSet<Integer> marked = new HashSet<>();
        return dfs(src, dst, marked);
    }

    private boolean dfs(int v, int dist, HashSet<Integer> marked) {
        if (v == dist) return true;
        marked.add(v);

        for(int w: adj.getOrDefault(v, new HashSet<>())) {
            if (!marked.contains(w)) {
                boolean isFound = dfs(w, dist, marked);
                if (isFound) return isFound;
            }
        }
        return false;
    }
}
