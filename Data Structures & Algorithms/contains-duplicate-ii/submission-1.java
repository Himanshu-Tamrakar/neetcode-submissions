class Solution {
    /**
    * O(n * k)
    * Ok if k is small
    */
    // public boolean containsNearbyDuplicate(int[] nums, int k) {
    //     for (int L = 0; L < nums.length; L++) {
    //         for (int R = L + 1; R < Math.min(nums.length, L + k + 1); R++) {
    //             if (nums[L] == nums[R]) return true;
    //         }
    //     }

    //     return false;
    // }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> st = new HashSet<>();
        int L = 0;
        for (int i = 0; i < nums.length; i++) {
            if (st.size() > k) {
                st.remove(nums[L]);
                L++;
            }

            if (st.contains(nums[i])) return true;
            st.add(nums[i]);
        }

        return false;
    }


}