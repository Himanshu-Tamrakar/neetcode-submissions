class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int product = 1;
        int totalZeros = 0;
        for (int num: nums) { 
           if (num != 0) product *= num;
           else totalZeros++;
        }

        if (totalZeros > 1) return res;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) res[i] = product;
            else res[i] = totalZeros > 0 ? 0 : product / nums[i];
        }
        return res;
    }
}  
