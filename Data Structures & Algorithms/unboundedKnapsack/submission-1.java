class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int[][] memo = new int[profit.size()][capacity + 1];
        for (int[] row: memo) Arrays.fill(row, -1);
        return dfs(0, memo, profit, weight, capacity);
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
