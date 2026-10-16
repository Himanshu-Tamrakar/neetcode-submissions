class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] time: times) {
            int v = time[0], w = time[1], weight = time[2];
            adj.get(v).add(new int[]{v, w, weight});
        }

        Map<Integer, Integer> distTo = new HashMap<>();
        PriorityQueue<int[]> min = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        min.offer(new int[] {k, 0});

        int time = 0;
        while (!min.isEmpty()) {
            int[] curr = min.poll();
            int destination = curr[0];
            int destinationWeight = curr[1];

            if (distTo.containsKey(destination)) {
                continue;
            }
            distTo.put(destination, destinationWeight);
            time = destinationWeight;

            for (int[] next: adj.get(destination)) {
                int v = next[0];
                int w = next[1];
                int weight = next[2];

                if (!distTo.containsKey(w)) {
                    min.offer(new int[] {w, destinationWeight + weight});
                }
            }

        }

        return distTo.size() == n ? time : -1;
    }
}
