class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> byDist = (p1, p2) -> {
            int dist1 = p1[0] * p1[0] + p1[1] * p1[1];
            int dist2 = p2[0] * p2[0] + p2[1] * p2[1];
            return Integer.compare(dist2, dist1);
        };

        PriorityQueue<int[]> maxPQ = new PriorityQueue<>(byDist);

        for (int[] point: points) {
            maxPQ.offer(point);
            if (maxPQ.size() > k) {
                maxPQ.poll();
            }
        }
        
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = maxPQ.poll();
        }
        
        return res;
    }

    // nlog(n)
    // public int[][] kClosest(int[][] points, int k) {
    //     Comparator<int[]> byDistance = (p1, p2) -> compateByDist(p1, p2);
    //     Arrays.sort(points, byDistance);
    //     return Arrays.copyOfRange(points, 0, k);
    // }

    // private int compateByDist(int[] p1, int[] p2) {
    //     int dist1 = p1[0] * p1[0] + p1[1] * p1[1];
    //     int dist2 = p2[0] * p2[0] + p2[1] * p2[1];
    //     return Integer.compare(dist1, dist2);
    // }
}
