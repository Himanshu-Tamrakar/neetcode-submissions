class Solution {
    /**
    * Bruteforce O(n ^ 2)
    */
    // public int minSubArrayLen(int target, int[] nums) {
    //     int res = Integer.MAX_VALUE;
    //     for (int i = 0; i < nums.length; i++) {
    //         int currSum = 0;
    //         for (int j = i; j < nums.length; j++) {
    //             currSum += nums[j];
    //             if (currSum >= target) {
    //                 res = Math.min(res, j - i + 1);
    //             }
    //         }
    //     }

    //     return res == Integer.MAX_VALUE ? 0 : res;
    // }

     public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int L = 0;
        int currSum = 0;
        for (int R = 0; R < nums.length; R++) {
            currSum += nums[R];
            while (currSum >= target) {
                res = Math.min(res, R - L + 1);
                currSum -= nums[L++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}