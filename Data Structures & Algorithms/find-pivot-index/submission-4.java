class Solution {
    public int pivotIndex(int[] nums) {
        int prefix = 0;
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }

        // suffix of i+1 = sum - prefix of i - 1 + val of i
        // if (suffix of i + 1) == (prefix of i -1)

        for (int i = 0; i < nums.length; i++) {
            if ((sum - (prefix + nums[i])) == prefix) {
                return i;
            }

            prefix += nums[i];
        }
        

        return -1;
    }
}