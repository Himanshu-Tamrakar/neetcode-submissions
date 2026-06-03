class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        return Math.max(helper(Arrays.copyOfRange(nums, 1, nums.length)),
                        helper(Arrays.copyOfRange(nums, 0, nums.length-1)));

    }

    private int helper(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(
                nums[i] + dp[i - 2],
                dp[i - 1]
            );
        }

        return dp[nums.length-1];
    }
    // public int rob(int[] nums) {

    //     int n = nums.length;
    //     if (n == 0) return 0;
    //     if (n == 1) return nums[0];

    //     int[] memo = new int[n];

    //     Arrays.fill(memo, -1);
    //     int res1 = dfs(nums, 0, n - 1, memo);

    //     Arrays.fill(memo, -1);
    //     int res2 = dfs(nums, 1, n, memo);

    //     return Math.max(res1, res2);
        
    // }

    // private int dfs(int[] nums, int i, int n, int[] memo) {
    //     if (i >= n) return 0;

    //     if (memo[i] != -1) return memo[i];

    //     memo[i] = Math.max(
    //         nums[i] + dfs(nums, i + 2, n, memo),
    //         dfs(nums, i + 1, n, memo)
    //     );

    //     return memo[i];
    // }
}
