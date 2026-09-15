class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int L = 0;
        int R = 1;
        Set<Integer> window = new HashSet();
        window.add(nums[L]);

        while (R < nums.length) {
            if (R - L > k) {
                window.remove(nums[L]);
                L += 1;
            }
            if (window.contains(nums[R])) {
                return true;
            }

            window.add(nums[R]);
            R++;
        }
        return false;
    }
}