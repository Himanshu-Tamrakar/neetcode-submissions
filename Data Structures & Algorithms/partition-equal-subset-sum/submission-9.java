class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }
         
        int mid = sum / 2;

        int[][] cache = new int[nums.length][mid + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return helper(0, nums, mid, cache);

    }

    private boolean helper(int i, int[] nums, int capacity, int[][] cache) {
        if (capacity == 0) {
            return true;
        }

        if (i == nums.length) {
            return false;
        }

        if (cache[i][capacity] != -1) {
            return cache[i][capacity] == 0 ? false : true;
        }

        boolean skip = helper(i + 1, nums, capacity, cache);
        boolean with = false;
        int newCap = capacity - nums[i];
        if (newCap >= 0) {
            with = helper(i + 1, nums, newCap, cache);
        }

        cache[i][capacity] = (skip || with) ? 1 : 0;

        return cache[i][capacity] == 0 ? false : true;
    }
}
