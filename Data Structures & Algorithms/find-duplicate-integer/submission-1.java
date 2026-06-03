class Solution {
    // public int findDuplicate(int[] nums) {
    //     Set<Integer> st = new HashSet<>();
    //     for (int num: nums) {
    //         if (st.contains(num)) return num;
    //         st.add(num);
    //     }
    //     return -1;
    // }

    public int findDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == (i+1)) continue;

            while (nums[i] != (i + 1)) {
                int j = nums[i];
                if (nums[j - 1] == j) return j;
                nums[i] = nums[j - 1];
                nums[j - 1] = j;
            }

        }

        return -1;

    }
}
