class Solution {
    public int minCostConnectPoints(int[][] points) {
        int N = points.length;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{dist, j});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{dist, i});
                
            }
        }
    

    int res = 0;
    Set<Integer> visit = new HashSet<>();
    PriorityQueue<int[]> min = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    min.offer(new int[]{0, 0});

    while (visit.size() < N) {
        int[] curr = min.poll();
        int cost = curr[0];
        int w = curr[1];
        if (visit.contains(w)) {
            continue;
        }
        res += cost;
        visit.add(w);
        for (int[] nei : adj.getOrDefault(w, Collections.emptyList())) {
            int neiCost = nei[0];
            int neiW = nei[1];
            if (!visit.contains(neiW)) {
                min.offer(new int[] {neiCost, neiW});
            }
        }
    }

    return res;
    }
}
