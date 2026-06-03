class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currSum = 0;
            for (int j = i; j < nums.length; j++) {
                currSum += nums[j];
                if (currSum >= target) {
                    res = Math.min(res, j - i + 1);
                }
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}