class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        HashMap<Integer, Integer> st = new HashMap<>();
        st.put(0, 1);
        int prefix = 0;
        for(int num: nums) {
            prefix += num;
            int key = prefix - k;
            res += st.getOrDefault(key, 0);
            st.put(prefix, st.getOrDefault(prefix, 0) + 1);       
        }
        return res;
    }
}