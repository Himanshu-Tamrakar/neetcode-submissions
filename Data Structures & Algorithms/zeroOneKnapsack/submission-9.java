class Solution {
    // top down dp
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int N = profit.size();
        int M = capacity + 1;
        int[][] dp = new int[N][M];
        for (int r = 0; r < N; r++) {
            dp[r][0] = 0;
        }

        for (int c = 0; c < M; c++) {
            if (c >= weight.get(0)) {
                dp[0][c] = profit.get(0);
            }
        }

        for (int r = 1; r < N; r++) {
            for (int c = 0; c < M; c++) {
                int skip = dp[r-1][c];
                int include = 0;
                if (c - weight.get(r) >= 0) {   
                    include = profit.get(r) + dp[r-1][c - weight.get(r)];
                }
                dp[r][c] = Math.max(skip, include);
            }
        }

        return dp[N-1][M-1];
        
    }

    // memoization
    private int maxHelper(int i, int capacity, List<Integer> profits, List<Integer> weights, int[][] cache) {
        if (i == profits.size()) {
            return 0;
        }

        if (cache[i][capacity] != -1) {
            return cache[i][capacity];
        }

        int maxProfit = maxHelper(i + 1, capacity, profits, weights, cache);

        int newCap = capacity - weights.get(i);
        if (newCap >= 0) {
            int p = profits.get(i) + maxHelper(i + 1, newCap, profits, weights, cache);

            maxProfit = Math.max(maxProfit, p);
        }
        cache[i][capacity] = maxProfit;

        return cache[i][capacity];
    }
}
