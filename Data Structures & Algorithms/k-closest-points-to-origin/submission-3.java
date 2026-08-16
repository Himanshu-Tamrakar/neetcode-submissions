class Solution {

    public int[][] kClosest(int[][] points, int k) {
        return kClosest(points, 0, points.length - 1, k);
    }

    private int[][] kClosest(int[][] points, int lo, int hi, int k) {
        if (lo > hi) return new int[0][2];

        int j = rank(points, lo, hi);
        System.out.println("first partition" + j);

        if ((j+1) < k) {
            return kClosest(points, j + 1, hi, k);
        } else if ((j+1) > k) {
            return kClosest(points, lo, j - 1, k);
        } else {
            return Arrays.copyOfRange(points, 0, k);
        }
    }

    private int rank(int[][] points, int lo, int hi) {
        int pivotIdx = lo;
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(points[++i], points[pivotIdx])) {
                System.out.println("i" + i);
                if (i == hi) break;
            }
            while (less(points[pivotIdx], points[--j])) {
                System.out.println("j"+j);
                if (j == lo) break;
            }
            if (i >= j) break;
            exch(points, i, j);
        }

        exch(points, lo, j);
        return j;
    }

    private boolean less(int[] p1, int[] p2) {
        int dist1 = p1[0] * p1[0] + p1[1] * p1[1];
        int dist2 = p2[0] * p2[0] + p2[1] * p2[1];
        return Integer.compare(dist1, dist2) < 0;
    }

    private void exch(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    // nlog(k)
    // public int[][] kClosest(int[][] points, int k) {
    //     Comparator<int[]> byDist = (p1, p2) -> {
    //         int dist1 = p1[0] * p1[0] + p1[1] * p1[1];
    //         int dist2 = p2[0] * p2[0] + p2[1] * p2[1];
    //         return Integer.compare(dist2, dist1);
    //     };

    //     PriorityQueue<int[]> maxPQ = new PriorityQueue<>(byDist);

    //     for (int[] point: points) {
    //         maxPQ.offer(point);
    //         if (maxPQ.size() > k) {
    //             maxPQ.poll();
    //         }
    //     }
        
    //     int[][] res = new int[k][2];
    //     for (int i = 0; i < k; i++) {
    //         res[i] = maxPQ.poll();
    //     }

    //     return res;
    // }

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
