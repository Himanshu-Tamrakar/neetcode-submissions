class Solution {

    public int rob(int[] nums) {
        
        int n = nums.length;

        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(
                nums[i] + dp[i - 2],
                dp[i - 1]
            );
        }

        return dp[n-1];
    }


    // public int rob(int[] nums) {
    //     int n = nums.length;
    //     int[] memo = new int[n + 1];
    //     Arrays.fill(memo, -1);

    //     return dfs(nums, 0, memo);
    // }

    // private int dfs(int[] nums, int i, int[] memo) {
    //     if (i >= nums.length) return 0;

    //     if (memo[i] != -1) return memo[i];

    //     memo[i] = Math.max(
    //         nums[i] + dfs(nums, i + 2, memo),
    //         dfs(nums, i + 1, memo)
    //     );

    //     return memo[i];
    // }
}
