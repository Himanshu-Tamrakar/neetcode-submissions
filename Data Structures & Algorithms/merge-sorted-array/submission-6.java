class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n -1;
        int i = m - 1;
        int j = n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[last--] = nums1[i--];
            } else {
                nums1[last--] = nums2[j--];
            }
        }
        
        
    }

    // public void merge(int[] nums1, int m, int[] nums2, int n) {
    //     int[] temp = new int[m];
    //     for(int i = 0; i < m; i++) {
    //         temp[i] = nums1[i];
    //     }
    //     int lo = 0;
    //     int mid = 0;
    //     int i = 0;
    //     while(lo < m || mid < n) {
    //         if (lo == m) {
    //             nums1[i++] = nums2[mid++];
    //         } else if (mid == n) {
    //             nums1[i++] = temp[lo++];
    //         } else {
    //             if (temp[lo] <= nums2[mid]) {
    //                 nums1[i++] = temp[lo++];
    //             } else {
    //                 nums1[i++] = nums2[mid++];    
    //             }
    //         }
    //     }
    // }

    // like insertion sort
    // public void merge(int[] nums1, int m, int[] nums2, int n) {
    //     for (int i = 0; i < n; i++) {
    //         nums1[m + i] = nums2[i];
    //         int j = m + i - 1;

    //         for(j = m + i; j > 0 && less(nums1, j, j - 1); j--) {
    //             exch(nums1, j, j - 1);
    //         }
            
    //     }
    // }

    // private boolean less(int[] nums, int i, int j) {
    //     return nums[i] < nums[j];
    // }

    // private void exch(int[] nums, int i, int j) {
    //     int temp = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = temp;
    // }
}

// pr


// [0,0,10,20,20,40]
// [1,2]
// m = -1
// n = 1
// len = 2



// [1,20,20,40,10,0]
// [1,2]

// [1,10,20,40,0,0]
// [20,2]             

// [1,10,20,40,0,0]
// [20,2]             m

// [1,10,20,20,2,0]
// [0,2]             m

            //    i  


// [1,2,10,20,20,40]