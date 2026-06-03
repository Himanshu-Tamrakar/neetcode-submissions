class Solution {
     public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum % 2) != 0) return false;

        int target = sum / 2;

        return dfs(0, nums, target);
    }

    private boolean dfs(int i, int[] nums, int cap) {
        if (i == nums.length) return false;

        if (cap == 0) return true;
        if (cap < 0) return false;

        return dfs(i + 1, nums, cap) || dfs(i + 1, nums, cap - nums[i]);

    }

   
}
