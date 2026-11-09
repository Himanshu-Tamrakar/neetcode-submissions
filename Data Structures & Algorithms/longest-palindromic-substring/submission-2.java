class Solution {
    public String longestPalindrome(String s) {
        int len = 0;
        int index = 0;


        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            // odd length palindrom
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > len) {
                    index = l;
                    len = r - l + 1;
                }
                l--;
                r++;
            }

            // even length palindrom
            l = i; 
            r = i + 1;
            while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1) > len) {
                    index = l;
                    len = r - l + 1;
                }
                l--;
                r++;
            }

        }
        return s.substring(index, index + len);
    }
}
