class Solution {

    public int lengthOfLIS(int[] nums)  {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }

        }
        int max = 0;
        for (int num: dp) max = Math.max(max, num);
        return max;
    }
    // public int lengthOfLIS(int[] nums) {
    //     return dfs(nums, 0, -1);
    // }

    // private int dfs(int[] nums, int i, int j) {
    //     if (i == nums.length) {
    //         return 0;
    //     }

    //     int LIS = dfs(nums, i + 1, j);

    //     if (j == -1 || nums[j] < nums[i]) {
    //         LIS = Math.max(
    //             LIS,
    //             1 + dfs(nums, i + 1, i)
    //         );
    //     }

    //     return LIS;

    // }
}
