class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int currMax = 0;
        int currMin = 0;
        int max = nums[0];
        int min = nums[0];
        int sum = 0;

        for (int num: nums) sum += num;

        for (int num: nums) {
            currMax = Math.max(num, currMax + num);
            currMin = Math.min(num, currMin + num);

            max = Math.max(currMax, max);
            min = Math.min(currMin, min);
        }

        return max > 0 ? Math.max(max, sum - min) : max;
        
    }
}