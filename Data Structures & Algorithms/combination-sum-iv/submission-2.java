class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        return dfs(nums, target, memo);
    }

    private int dfs(int[] nums, int target, Map<Integer, Integer> memo) {
        if (target < 0) return 0;
        if (target == 0) return 1;
        if (memo.containsKey(target)) return memo.get(target);

        int count = 0;
        for (int j = 0; j < nums.length; j++) {
            count += dfs(nums, target - nums[j], memo);
        }

        memo.put(target, count);
        return memo.get(target);
    }
}