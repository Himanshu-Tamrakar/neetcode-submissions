class Solution {
    private class Point implements Comparable<Point> {
        int x;
        int y;
        int dist;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = x * x + y * y;
        }

        public int compareTo(Point that) {
            return Integer.compare(this.dist, that.dist);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> minPQ = new PriorityQueue<>();
        for (int[] point: points) {
            Point p = new Point(point[0], point[1]);
            minPQ.offer(p);
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            Point p = minPQ.poll();
            res[i] = new int[]{p.x, p.y};
        }
        return res;
    }

    // public int[][] kClosest(int[][] points, int k) {
    //     PriorityQueue<int[]> minPQ = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
    //     for (int[] point: points) {
    //         int dist = point[0] * point[0] + point[1] * point[1];
    //         minPQ.offer(new int[] {dist, point[0], point[1]});
    //     }

    //     int[][] res = new int[k][2];
    //     for (int i = 0; i < k; i++) {
    //         int[] point = minPQ.poll();
    //         res[i] = new int[] {point[1], point[2]};
    //     }
        
    //     return res;

    // }
}
