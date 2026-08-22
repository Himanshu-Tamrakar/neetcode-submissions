class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, nums.length  - k);
    }

    private int findKthLargest(int[] nums, int lo, int hi, int k) {
        if (lo > hi) return -1;

        int j = rank(nums, lo, hi);

        if (j < k) {
            return findKthLargest(nums, j + 1, hi, k);
        } else if (j > k) {
            return findKthLargest(nums, lo, j - 1, k);
        } else {
            return nums[j];
        }
    }

    private int rank(int[] nums, int lo, int hi) {
        int pivotIdx = lo;
        int i = lo;
        int j = hi + 1;
        while (true) {
            while ((i+1) < nums.length && less(nums[++i], nums[pivotIdx])) {
                if (i == hi) break;
            }

            while ((j-1) >= 0 && less(nums[pivotIdx], nums[--j])) {
                if (j == lo) break;
            }

            if (i >= j) break;
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }

    private boolean less(int a, int b) {
        return Integer.compare(a, b) <= 0;
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
