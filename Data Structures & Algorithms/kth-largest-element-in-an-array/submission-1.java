class Solution {
    // public int findKthLargest(int[] nums, int k) {
    //     Arrays.sort(nums);
    //     return nums[nums.length - k];
    // }

    // follow-up without sorting using couting sort which is order of N time 
     public int findKthLargest(int[] nums, int k) {
        int[] count = new int[2001];

        for (int num: nums)
            count[num + 1000]++;

        for (int i = 2000; i >= 0; i--) {
            k -= count[i];
            if (k <= 0) return i - 1000;
        }
        return -1;
     }

}
