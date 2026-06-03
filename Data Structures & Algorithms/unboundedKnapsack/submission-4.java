class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int n = profit.size();
        int[] dp = new int[capacity + 1];

        for (int r = 0; r < n; r++) {
            int[] dpNew = new int[capacity + 1];
            for (int c = 0; c <= capacity; c++) {
                int max = dp[c];

                if (c - weight.get(r) >= 0) {
                    int with = profit.get(r) + dpNew[c - weight.get(r)];
                    max = Math.max(max, with);
                }

                dpNew[c] = max;
            }
            dp = dpNew;

        }

        return dp[capacity];

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
