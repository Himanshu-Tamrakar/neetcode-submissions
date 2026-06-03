class Solution {
    int totalSum = 0;
    int[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num: nums) sum += num;
        totalSum = sum;
        dp = new int[nums.length][2 * sum + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        return dfs(0, nums, 0, target);
        
    }

    private int dfs(int i, int[] nums, int total, int target) {
            
        if (i == nums.length) {
            if (target == total) return 1;
            else return 0;
        };
        if (dp[i][total + totalSum] != Integer.MIN_VALUE) return dp[i][total + totalSum];
        

        int add = dfs(i + 1, nums, total + nums[i], target);
        int sub = dfs(i + 1, nums, total - nums[i], target);
        dp[i][total + totalSum] = add + sub;

        return dp[i][total + totalSum];

    }
}
