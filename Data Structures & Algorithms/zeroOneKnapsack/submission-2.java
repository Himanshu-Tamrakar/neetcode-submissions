class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int N = profit.size();
        int M = capacity;
        int[][] dp = new int[profit.size()][capacity+1];
        for (int r = 0; r < N; r++) {
            dp[r][0] = 0;
        }
        for (int c = 1; c <= M; c++) {
            if (c >= weight.get(0)) dp[0][c] = profit.get(0);
        }

        for (int r = 1; r < N; r++) {
            for (int c = 1; c <= M; c++) {
                int skip = dp[r-1][c];
                int p = 0;
                if (c >= weight.get(r)) {
                    p = profit.get(r);
                }
                if (c - weight.get(r) >= 0) {
                    p += dp[r-1][c - weight.get(r)];
                }

                dp[r][c] = Math.max(skip, p);
            }
        }

        return dp[N-1][M];

    }

}
