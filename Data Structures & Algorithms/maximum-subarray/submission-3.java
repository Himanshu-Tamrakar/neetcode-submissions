class Solution {
    /**
    * Brute force O(n^2)
    */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum = 0;
            for (int j = i; j < n; j++) {
                currSum += nums[j];
                maxSum = Math.max(maxSum, currSum);
            }
        }

        return maxSum;
    }

    /**
    * Kadane's Algorithms
    */
    // public int maxSubArray(int[] nums) {
    //     int maxSum = nums[0];
    //     int currSum = 0;
    //     for (int num: nums) {
    //         currSum = Math.max(0, currSum);
    //         currSum += num;
    //         maxSum = Math.max(maxSum, currSum);
    //     }

    //     return maxSum;
    // }
}
