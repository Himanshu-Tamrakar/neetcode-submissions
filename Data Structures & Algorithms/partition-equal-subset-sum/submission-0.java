class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) sum += num;

        if (sum % 2 != 0) return false;

        return dfs(nums, 0, 0, sum/2); 
    }

    private boolean dfs(int[] nums, int i, int total, int target) {
        int N = nums.length;
        if (i == N) return false;

        if (total == target) return true;        

        total += nums[i];
        boolean res1 = dfs(nums, i+1, total, target);

        total -= nums[i];
        boolean res2 = dfs(nums, i+1, total, target);

        return res1 || res2;
    }
}
