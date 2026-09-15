class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int L = 0;
        Set<Integer> window = new HashSet();

        for (int R = 0; R < nums.length; R++) {
            if (R - L > k) {
                window.remove(nums[L]);
                L += 1;
            }
            if (window.contains(nums[R])) {
                return true;
            }

            window.add(nums[R]);
            
        }
        return false;
    }
}