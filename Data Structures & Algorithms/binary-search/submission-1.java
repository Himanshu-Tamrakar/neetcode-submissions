class Solution {
    // public int search(int[] nums, int target) {
    //     int lo = 0;
    //     int hi = nums.length - 1;
    //     while (lo <= hi) {
    //         int mid = lo + (hi - lo) / 2;
    //         if (nums[mid] < target) {
    //             lo = mid + 1;
    //         } else if (nums[mid] > target) {
    //             hi = mid - 1;
    //         } else {
    //             return mid;
    //         }
    //     }
    //     return -1;
    // }

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    private int search(int[] nums, int target, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] < target) return search(nums, target, mid+1, hi);
        else if (nums[mid] > target) return search(nums, target, lo, mid - 1);
        else return mid;
    }
}
