class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int[] arrNew = new int[nums1.length];
        int k = 0;
        while (i < m && j < n) {
            arrNew[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }

        while (i < m) {
            arrNew[k++] = nums1[i++];
        }

        while(j < n) {
            arrNew[k++] = nums2[j++];
        }

        for (int l = 0; l < nums1.length; l++) {
            nums1[l] = arrNew[l];
        }

    }
}