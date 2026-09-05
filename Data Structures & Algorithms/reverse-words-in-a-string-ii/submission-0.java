class Solution {
    public void reverseWords(char[] s) {

        // phase 1
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }

        // phase 2 reverse each words
        int lo = 0; int hi = 0;
        while (hi < s.length) {
            while (hi < s.length && s[hi] != ' ') {
                hi++;
            }

            int tempHi = hi;
            hi--;

            while (lo < hi) {
                char temp = s[lo];
                s[lo] = s[hi];
                s[hi] = temp;
                lo++;
                hi--;
            }

            lo = tempHi + 1;
            hi = lo;
        }

        
    }
}
