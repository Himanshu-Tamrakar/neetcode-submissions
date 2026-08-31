class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        for (int i=0; i < nums.length; i++) {
            memo[i] = -1;
        }
        return dfs(nums, 0, memo);
    }

    private int dfs(int[] nums, int i, int[] memo) {
        if (i >= nums.length) return 0;
        if (memo[i] != -1) return memo[i];

        memo[i] = Math.max(
            dfs(nums, i + 1, memo),
            nums[i] + dfs(nums, i + 2, memo)
        );

        return memo[i];
    }

    // public int rob(int[] nums) {
    //     return dfs(nums, 0);
    // }

    // private int dfs(int[] nums, int i) {
    //     if (i >= nums.length) return 0;

    //     return Math.max(
    //         dfs(nums, i + 1),
    //         nums[i] + dfs(nums, i + 2)
    //     );
    // }

}
