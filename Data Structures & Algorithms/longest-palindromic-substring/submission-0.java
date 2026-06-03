class Solution {
    public String longestPalindrome(String s) {
        int startIndex = 0; 
        int endIndex = 0;
        int length = 0;

        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > length) {
                    length = r - l + 1;
                    startIndex = l;
                    endIndex = r;
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > length) {
                    length = r - l + 1;
                    startIndex = l;
                    endIndex = r; 
                }
                l--;
                r++;
            }

        }

        return s.substring(startIndex, endIndex + 1);


    }

   
}

