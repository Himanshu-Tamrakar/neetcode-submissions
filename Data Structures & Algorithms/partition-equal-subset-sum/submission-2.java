class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) sum += num;

        if (sum % 2 != 0) return false;

        return dfs(nums, 0, sum/2); 
    }

    private boolean dfs(int[] nums, int i, int target) {
        int N = nums.length;
        
        if (i == N) return false;
        if (target < 0) return false;

        if (target == 0) return true;        

        target -= nums[i];
        boolean res1 = dfs(nums, i+1, target);

        target += nums[i];
        boolean res2 = dfs(nums, i+1, target);

        return res1 || res2;
    }
}
