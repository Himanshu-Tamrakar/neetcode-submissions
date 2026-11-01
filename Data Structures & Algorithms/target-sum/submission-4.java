class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> cache = new HashMap<>();
        return helper(0, 0, nums, target, cache);
    }

    private int helper(int i, int total, int[] nums, int target, Map<String, Integer> cache) {
        if (cache.containsKey(i + ":" + total)) {
            return cache.get(i + ":" + total);
        }
        if (i == nums.length) {
            return target == total ? 1 : 0;
        }

        int t = helper(i + 1, total + nums[i], nums, target, cache) + helper(i + 1, total - nums[i], nums, target, cache);
        cache.put(i + ":" + total, t);
        return t;
    }
}
