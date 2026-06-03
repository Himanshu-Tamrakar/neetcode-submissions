class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        return dfs(nums, 0, 0, target);
        
    }

    private int dfs(int[] nums, int i, int total, int target) {
        if (i == nums.length) {
            if (target == total) return 1;
            else return 0;
        };
        

        int add = dfs(nums, i+1, total + nums[i], target);
        int sub = dfs(nums, i+1, total - nums[i], target);

        return add + sub;

    }
}
