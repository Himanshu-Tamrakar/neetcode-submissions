class Solution {
    /**
    * Brute force O(n^2)
    */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum = nums[i];
            for (int j = i + 1; j < n; j++) {
                currSum += nums[j];
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }

            if (currSum > maxSum) {
                maxSum = currSum;
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
