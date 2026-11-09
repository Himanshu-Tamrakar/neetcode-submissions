class Solution {
    public String longestPalindrome(String s) {
        String palindrom = "";

        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            // odd length palindrom
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1) > palindrom.length()) {
                    palindrom = s.substring(l, r + 1);
                }
                l--;
                r++;
            }

            // even length palindrom
            l = i; 
            r = i + 1;
            while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1) > palindrom.length()) {
                    palindrom = s.substring(l, r + 1);
                }
                l--;
                r++;
            }

        }
        return palindrom;
    }
}
