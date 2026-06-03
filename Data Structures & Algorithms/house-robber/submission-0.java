class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return dfs(nums, 0, memo);
    }

    private int dfs(int[] nums, int i, int[] memo) {
        if (i >= nums.length) return 0;

        if (memo[i] != -1) return memo[i];

        memo[i] = Math.max(
            nums[i] + dfs(nums, i + 2, memo),
            dfs(nums, i + 1, memo)
        );

        return memo[i];
    }
}
