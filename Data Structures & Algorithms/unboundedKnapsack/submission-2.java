class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int n = profit.size();
        int[][] dp = new int[profit.size()][capacity + 1];
        
        for (int r = 0; r < n; r++) {
            dp[r][0] = 0;
        }
        for (int c = 1; c <= capacity; c++) {
            if (c >= weight.get(0)) {
                dp[0][c] = profit.get(0) * (c / weight.get(0)); // because we are allowed to take same elem multiple times
            }
        }

        for (int r = 1; r < n; r++) {
            for (int c = 1; c <= capacity; c++) {
                int max = dp[r-1][c];

                if (c - weight.get(r) >= 0) {
                    int with = profit.get(r) + dp[r][c - weight.get(r)];
                    max = Math.max(max, with);
                }
                dp[r][c] = max;
            }

        }

        return dp[n-1][capacity];

    }

    private int dfs(int i, int[][] memo, List<Integer> profit, List<Integer> weight, int cap) {
        if (i == profit.size()) {
            return 0;
        }
        if (memo[i][cap] != -1) return memo[i][cap];

        int maxProfit = dfs(i + 1, memo, profit, weight, cap);
        int newCap = cap - weight.get(i);
        if (newCap >= 0) {
            int with = profit.get(i) + dfs(i, memo, profit, weight, newCap);
            maxProfit = Math.max(maxProfit, with);
        }
        memo[i][cap] = maxProfit;
        return memo[i][cap];
    }
}
