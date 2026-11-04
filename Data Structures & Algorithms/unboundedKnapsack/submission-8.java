class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int N = profit.size();
        int M = capacity + 1;
        int[][] dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < M; i++) {
            dp[0][i] = i >= weight.get(0) ? (profit.get(0) + dp[0][i - weight.get(0)]) : 0;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                int skip = dp[i - 1][j];
                int include = 0;
                if (j - weight.get(i) >= 0) {
                    include = profit.get(i) + dp[i][j-weight.get(i)];
                }
                dp[i][j] = Math.max(skip, include);
            }
        }

        return dp[N-1][M-1];
    }

    public int maximumProfit1(List<Integer> profit, List<Integer> weight, int capacity) {
        int N = profit.size();
        int M = capacity + 1;
        int[][] cache = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cache[i][j] = -1;
            }
        }
        return helper1(0, profit, weight, capacity, cache);
    }

    private int helper1(int i, List<Integer> profit, List<Integer> weight, int capacity, int[][] cache) {
        if (i == profit.size()) {
            return 0;
        }
        if (cache[i][capacity] != -1) {
            return cache[i][capacity];
        }

        int skip = helper1(i + 1, profit, weight, capacity, cache);
        int include = 0;
        int newCap = capacity - weight.get(i);
        if (newCap >= 0) {
            include = profit.get(i) + helper1(i, profit, weight, newCap, cache);
        }
        cache[i][capacity] = Math.max(skip, include);
        return cache[i][capacity];
    }
}
