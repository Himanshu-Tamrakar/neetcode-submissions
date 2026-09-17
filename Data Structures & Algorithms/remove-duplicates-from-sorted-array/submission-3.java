class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 1;

        while (r < nums.length) {

            // move r until it is same as l
            while (r < nums.length && nums[l] == nums[r]) {
                r++;
            }

            if (r == nums.length) {
                break;
            }

            nums[++l] = nums[r++];
        }

        return l + 1;
    }
}