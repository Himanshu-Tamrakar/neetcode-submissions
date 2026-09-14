class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currSum = 0;
        int L = 0;
        int R = 0;
        for (int i = 0; i < nums.length; i++) {

            currSum = Math.max(currSum, 0);
            currSum += nums[i];

            max = Math.max(max, currSum);
        }

        return max;
    }
}
