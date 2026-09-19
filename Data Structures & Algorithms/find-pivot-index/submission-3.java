class Solution {
    public int pivotIndex(int[] nums) {
        int prefix = 0;
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if ((sum - (prefix + nums[i])) == prefix) {
                return i;
            }

            prefix += nums[i];
        }
        

        return -1;
    }
}