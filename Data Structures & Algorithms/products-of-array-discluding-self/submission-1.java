class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int curr = 1;
        for (int i = 0; i < nums.length; i++) {
            curr *= nums[i];
            prefix[i] = curr;
        }
        curr = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            curr *= nums[i];
            suffix[i] = curr;
        }
        for (int i = 0; i < nums.length; i++) {
            int leftPrefix = i == 0 ? 1 : prefix[i-1];
            int rightSuffix = i == nums.length-1 ? 1 : suffix[i+1];
            res[i] = leftPrefix * rightSuffix;
        }
        return res;
    }
}  
