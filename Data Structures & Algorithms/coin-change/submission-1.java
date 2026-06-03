class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[] memo = new Integer[amount + 1];
        int res = dfs(coins, memo, amount);

        return res >= ((int) 1e9) ? -1 : res;
    }

    private int dfs(int[] coins, Integer[] memo, int amount) {
        if (amount == 0) return 0;
        if (memo[amount] != null) return memo[amount];
        int res = (int) 1e9;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                res = Math.min (
                    res,
                    1 + dfs(coins, memo, amount - coins[i])
                );
            }
            
        }
        memo[amount] = res;
        return memo[amount];
    }
}
