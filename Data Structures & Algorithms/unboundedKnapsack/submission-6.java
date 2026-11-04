class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int N = profit.size();
        int M = capacity + 1;
        int[][] cache = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cache[i][j] = -1;
            }
        }
        return helper(0, profit, weight, capacity, cache);
    }

    private int helper(int i, List<Integer> profit, List<Integer> weight, int capacity, int[][] cache) {
        if (i == profit.size()) {
            return 0;
        }
        if (cache[i][capacity] != -1) {
            return cache[i][capacity];
        }

        int skip = helper(i + 1, profit, weight, capacity, cache);
        int include = 0;
        int newCap = capacity - weight.get(i);
        if (newCap >= 0) {
            include = profit.get(i) + helper(i, profit, weight, newCap, cache);
        }
        cache[i][capacity] = Math.max(skip, include);
        return cache[i][capacity];
    }
}
