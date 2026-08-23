class Solution {
    // public boolean hasDuplicate(int[] nums) {
    //     HashSet<Integer> st = new HashSet<>();
    //     for (int num: nums) {
    //         if (st.contains(num)) {
    //             return true;
    //         } else {
    //             st.add(num);
    //         }
    //     }

    //     return false;
    // }

    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        for (int num: nums) {
            st.add(num);
        }

        return st.size() != nums.length;
    }
}