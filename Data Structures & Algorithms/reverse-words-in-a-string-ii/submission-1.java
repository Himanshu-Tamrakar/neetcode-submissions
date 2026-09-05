class Solution {
    private void reverse(char[] s, int lo, int hi) {
        while (lo < hi) {
            char temp = s[lo];
            s[lo] = s[hi];
            s[hi] = temp;
            lo++;
            hi--;
        }
    }

   

    public void reverseWords(char[] s) {
        // phase 1 reverse whole string
        reverse(s, 0, s.length - 1);

        // phase 2 reverse each words
        int lo = 0; int hi = 0;
        while (hi < s.length) {
            while (hi < s.length && s[hi] != ' ') {
                hi++;
            }

            reverse(s, lo, hi - 1);

            lo = hi + 1;
            hi++;
        }

        
    }
}
