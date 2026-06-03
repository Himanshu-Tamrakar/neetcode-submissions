class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st = new HashSet<>();
        int L = 0;
        int res = 0;
        for (int R = 0; R < s.length(); R++) {
            while(st.contains(s.charAt(R))) {
                st.remove(s.charAt(L));
                L++;
            }
            st.add(s.charAt(R));
            res = Math.max(res, R - L + 1);
        }
        
        return res;
        
    }
}
