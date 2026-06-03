class Solution {
    public int pivotIndex(int[] nums) {

        int[] prefixSum = new int[nums.length];
        
        int curr = 0;
        for (int i = 0; i < nums.length; i++)  {
            curr += nums[i];
            prefixSum[i] = curr;  
        }
        

        for (int i = 0; i < nums.length; i++) {
            int prefix;
            if (i == 0) prefix = 0;
            else prefix = prefixSum[i-1];

            int suffix;
            if (i == nums.length-1) suffix = 0;
            else suffix = prefixSum[nums.length-1] - prefixSum[i];

            if (prefix == suffix) return i;
            
        }
        return -1;
            
        
    }
}