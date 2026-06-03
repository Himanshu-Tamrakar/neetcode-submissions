class Solution {
    private int n;
    public int integerBreak(int n) {
        this.n = n;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(n, memo);
    }

    private int dfs(int target, int[] memo) {
        if (target == 1) return 1;
        if (memo[target] != -1) return memo[target];

        int max = target == n ? 0 : target;

        for (int i = 1; i < target; i++) {
            max = Math.max(
                max,
                dfs(i, memo) * dfs(target - i, memo)
            );
        }
        memo[target] = max;
        return memo[target];

    }
}