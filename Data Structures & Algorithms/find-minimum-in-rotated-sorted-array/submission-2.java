class Solution {
    public int findMin(int[] nums) {
        
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int lo, int hi) {
        if (lo == hi) return nums[lo];

        if (nums[lo] < nums[hi]) return nums[lo];

        int mid = lo + (hi - lo) / 2;
        if (nums[lo] <= nums[mid]) {
            return Math.min(nums[mid], findMin(nums, mid + 1, hi));
        } else {
            return Math.min(nums[mid], findMin(nums, lo, mid - 1));
        }
    }
}
