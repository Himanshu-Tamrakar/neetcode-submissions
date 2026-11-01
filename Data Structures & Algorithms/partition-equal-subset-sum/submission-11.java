class Solution {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }
         
        int target = sum / 2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for (int num : nums) {
            Set<Integer> next = new HashSet<>(dp); 
            for (int t : dp) {
                int n = t + num;
                if (n == target) return true;
                if (n < target) next.add(n); 
            }
            dp = next;
        }
        return false;
    }

    public boolean canPartition1(int[] nums) {
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

    private boolean helper(int i, int[] nums, int target, int[][] cache) {
        if (target == 0) {
            return true;
        }

        if (i == nums.length) {
            return false;
        }

        if (cache[i][target] != -1) {
            return cache[i][target] == 0 ? false : true;
        }

        boolean skip = helper(i + 1, nums, target, cache);
        boolean with = false;
        int newCap = target - nums[i];
        if (newCap >= 0) {
            with = helper(i + 1, nums, newCap, cache);
        }

        cache[i][target] = (skip || with) ? 1 : 0;

        return cache[i][target] == 0 ? false : true;
    }
}
