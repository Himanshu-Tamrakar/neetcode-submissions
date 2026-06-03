class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        int curr = 1;
        for (int i = 0; i < nums.length-1; i++) {
            curr *= nums[i];
            res[i+1] = curr;
        }
        curr = 1;
        for (int i = nums.length-1; i > 0; i--) {
            curr *= nums[i];
            res[i-1] *= curr;
        }

        return res;
    }
}  
