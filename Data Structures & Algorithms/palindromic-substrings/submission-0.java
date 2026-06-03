class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            // odd length palindrom
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            // even length palindrom
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
        }
        return count;
    }
}
