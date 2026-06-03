class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Integer[] memo = new Integer[cost.length + 1];        
        return Math.min(
            dfs(cost, 0, memo),
            dfs(cost, 1, memo)
        );
    }

    private int dfs(int[] cost, int i, Integer[] memo) {
        if (i >= cost.length) return 0;
        if (memo[i] != null)  return memo[i];

        memo[i] = Math.min(
            cost[i] + dfs(cost, i + 1, memo),
            cost[i] + dfs(cost, i + 2, memo)
        );

        return memo[i];

    }
}
