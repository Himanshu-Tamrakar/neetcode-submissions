class Solution {
     public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum % 2) != 0) return false;

        int target = sum / 2;
        boolean[][] memo = new boolean[nums.length][target+1];

        return dfs(0, memo, nums, target);
    }

    private boolean dfs(int i, boolean[][] memo, int[] nums, int cap) {
        if (i == nums.length) return cap == 0;
        if (cap < 0) return false;
        if(memo[i][cap]) return true;

        memo[i][cap] =  dfs(i + 1, memo, nums, cap) || dfs(i + 1, memo, nums, cap - nums[i]);
        return memo[i][cap];

    }

   
}
