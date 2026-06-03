class Solution {
    public int maxProduct(int[] nums) {

        int res = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int max = nums[i];
            res = Math.max(res, max);

            for (int j = i + 1; j < nums.length; j++) {
                max = max * nums[j];
                res = Math.max(res, max);
            }
            
        }

        return res;
        
    }
}
