class Solution {
    int totalSum;
    int[][] dp;

    public int findTargetSumWays(int[] nums, int target) {
        totalSum = 0;
        for (int num : nums) totalSum += num;
        dp = new int[nums.length + 1][totalSum * 2 + 1];

        for(int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return backtrack(0, 0, nums, target);
    }

    public int backtrack(int i, int total, int[] nums, int target) {
        if(i >= nums.length) return total == target ? 1 : 0;
        if(dp[i][totalSum + total] != Integer.MIN_VALUE) return dp[i][totalSum + total];

        dp[i][totalSum + total] = backtrack(i + 1, total + nums[i], nums, target) + backtrack(i + 1, total - nums[i], nums, target);

        return dp[i][totalSum + total];
    }
}


// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         Map<String, Integer> cache = new HashMap<>();
//         return helper(0, 0, nums, target, cache);
//     }

//     private int helper(int i, int total, int[] nums, int target, Map<String, Integer> cache) {
//         if (cache.containsKey(i + ":" + total)) {
//             return cache.get(i + ":" + total);
//         }
//         if (i == nums.length) {
//             return target == total ? 1 : 0;
//         }

//         int t = helper(i + 1, total + nums[i], nums, target, cache) + helper(i + 1, total - nums[i], nums, target, cache);
//         cache.put(i + ":" + total, t);
//         return t;
//     }
// }
