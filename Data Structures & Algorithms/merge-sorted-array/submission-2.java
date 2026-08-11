class Solution {

    // public void merge(int[] nums1, int m, int[] nums2, int n) {

    // }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
            int j = m + i - 1;

            for(j = m + i; j > 0 && less(nums1, j, j - 1); j--) {
                exch(nums1, j, j - 1);
            }
            
        }
    }

    private boolean less(int[] nums, int i, int j) {
        return nums[i] < nums[j];
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// pr


// [10,20,20,40,0,0]
// [1,2]
// [1, 10,20,20,40,2]
//              m
//                i  


// [1,2,10,20,20,40]