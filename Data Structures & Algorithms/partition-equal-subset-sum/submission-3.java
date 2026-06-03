class Solution {
     public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum % 2) != 0) return false;

        int target = sum / 2;
        int n = nums.length;
        
        int[][] memo = new int[n + 1][target + 1];
        for (int[] row : memo) Arrays.fill(row, -1);

        return dfs(nums, 0, target, memo);
    }

     private boolean dfs(int[] nums, int i, int target, int[][] memo) {
        int n = nums.length;
        if (target == 0) return true;
        if (i == n) return false;
        if (target < 0) return false;

        if (memo[i][target] != -1) {
            return memo[i][target] == 1;
        }

        // Choose nums[i]
        boolean take = dfs(nums, i + 1, target - nums[i], memo);
        // Skip nums[i]
        boolean skip = dfs(nums, i + 1, target, memo);

        boolean res = take || skip;
        memo[i][target] = res ? 1 : 0;
        return res;
    }
}
