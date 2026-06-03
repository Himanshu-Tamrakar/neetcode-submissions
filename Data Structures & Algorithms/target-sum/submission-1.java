class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();

        return dfs(nums, 0, memo, 0, target);
        
    }

    private int dfs(int[] nums, int i, Map<String, Integer> memo, int total, int target) {
        if (memo.containsKey(i + "-" + total)) {
            return memo.get(i + "-" + total);
        }
        if (i == nums.length) {
            if (target == total) return 1;
            else return 0;
        };
        

        int add = dfs(nums, i+1, memo, total + nums[i], target);
        int sub = dfs(nums, i+1, memo, total - nums[i], target);
        memo.put(i+"-"+total, add + sub);

        return add + sub;

    }
}
