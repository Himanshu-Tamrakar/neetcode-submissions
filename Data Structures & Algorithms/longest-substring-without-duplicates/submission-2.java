class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> st = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (st.contains(s.charAt(j))) {
                    res = Math.max(res, st.size());
                    break;
                }

                st.add(s.charAt(j));
                res = Math.max(res, st.size());
            }

        }
        
        return res;
        
    }
}
