class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }

        return Math.min(cost[n -1], cost[n - 2]);
    }

    // 
    // public int minCostClimbingStairs(int[] cost) {
    //     int n = cost.length;
    //     int[] dp = new int[n + 1];        
    //     dp[1] = cost[0];
        
    //     for (int i = 2; i < dp.length; i++) {
    //         dp[i] = cost[i - 1] + Math.min(
    //             dp[i - 2],
    //             dp[i - 1] 
    //         );
    //     }

    //     return Math.min(dp[n], dp[n - 1]);
    // }

    // public int minCostClimbingStairs(int[] cost) {
    //     int[] memo = new int[cost.length + 1];        
    //     Arrays.fill(memo, -1)
    //     return Math.min(
    //         dfs(cost, 0, memo),
    //         dfs(cost, 1, memo)
    //     );
    // }

    // private int dfs(int[] cost, int i, int[] memo) {
    //     if (i >= cost.length) return 0;
    //     if (memo[i] != -1)  return memo[i];

    //     memo[i] = Math.min(
    //         cost[i] + dfs(cost, i + 1, memo),
    //         cost[i] + dfs(cost, i + 2, memo)
    //     );

    //     return memo[i];

    // }
}
