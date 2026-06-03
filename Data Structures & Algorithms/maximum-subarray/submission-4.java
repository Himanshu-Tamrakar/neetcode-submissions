class Solution {
    /**
    * Brute force O(n^2)
    */
    // public int maxSubArray(int[] nums) {
    //     int n = nums.length;
    //     int maxSum = nums[0];
    //     int currSum = 0;
    //     for (int i = 0; i < n; i++) {
    //         currSum = 0;
    //         for (int j = i; j < n; j++) {
    //             currSum += nums[j];
    //             maxSum = Math.max(maxSum, currSum);
    //         }
    //     }

    //     return maxSum;
    // }

    /**
    * Kadane's Algorithms
    */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;
        for (int num: nums) {
            currSum = Math.max(num, currSum + num);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    /**
    * Sliding Window
    * -2 1 -3 4 -1 2 1 -5 4
    */
    // public int[] slidingWindow(int[] nums) {
    //     int n = nums.length;
    //     int maxL = 0, maxR = 0;
    //     int maxSum = nums[0]; 
    //     int currSum = 0;
    //     int l = 0, r = 0;
    //     while (r < n) {
    //         if (currSum < 0) {
    //             currSum = 0;
    //             l = r;
    //         }
    //         currSum = Math.max(0, currSum);
    //         currSum += nums[r];
    //         if (maxSum < currSum) {
    //             maxL = l;
    //             maxR = r;
    //             maxSum = currSum;
    //         }
    //         r++;
    //     }
    //     return new int[] {maxL, maxR};
    // }
}
