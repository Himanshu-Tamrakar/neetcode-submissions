
class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, List<Integer[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<Integer[]>());
        }
        for (List<Integer> edge : edges) {
            int v = edge.get(0), w = edge.get(1), weight = edge.get(2);
            adj.get(v).add(new Integer[] {v, w, weight});
        }

        PriorityQueue<int[]> min = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[1], e2[1]));
        Map<Integer, Integer> distTo = new HashMap<>();
        min.offer(new int[] {src, 0}); // vertext and weight;

        while (!min.isEmpty()) {
            int[] node = min.poll();
            int vertex = node[0];
            int vertexWeight = node[1];

            if (distTo.containsKey(vertex)) {
                continue;
            }

            distTo.put(vertex, vertexWeight);

            for (Integer[] edge: adj.get(vertex)) {
                int v = edge[0];
                int w = edge[1];
                int weight = edge[2];

                if (!distTo.containsKey(w)) {
                    min.offer(new int[] {w, vertexWeight + weight});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            distTo.putIfAbsent(i, -1);
        }

        return distTo;
    }  
}
