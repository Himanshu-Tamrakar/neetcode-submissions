class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int globalMax = nums[0];
        int currMax = 0;
        int globalMin = nums[0];
        int currMin = 0;
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            currMax = Math.max(currMax, 0);
            currMax += nums[i];

            currMin = Math.min(currMin, 0);
            currMin += nums[i];

            globalMax = Math.max(globalMax, currMax);
            globalMin = Math.min(globalMin, currMin);

        }

        if (globalMax < 0) return globalMax;

        return Math.max(globalMax, total - globalMin);
        
    }
}