class Solution {
    // single pass o(n)
     public void sortColors(int[] nums) {
        int i = 0, l = 0, r = nums.length - 1;
        while (i <= r) {
            if (nums[i] == 0) {
                exch(nums, l, i);
                l++;
            } else if (nums[i] == 2) {
                exch(nums, i, r);
                r--;
                i--;
            }
            i++;
            
        }
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    // two pass o(n)
    // public void sortColors(int[] nums) {
    //     int[] count = new int[3];
    //     for (int num: nums) {
    //         count[num] += 1;
    //     }
    //     int cnt = 0;
    //     for (int i = 0; i < count.length; i++) {
    //         for (int j = 0; j < count[i]; j++) {
    //             nums[cnt++] = i;
    //         }
    //     }
    // }
}