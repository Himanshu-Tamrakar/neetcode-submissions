class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int L = 0;
        Set<Character> window = new HashSet<>();
        for (int R = 0; R < s.length(); R++) {
            char ch = s.charAt(R);
            while (window.contains(ch)) {
                window.remove(s.charAt(L++));
            }

            window.add(ch);
            res = Math.max(res, R - L + 1);
        }
        
        return res;
    }
}
