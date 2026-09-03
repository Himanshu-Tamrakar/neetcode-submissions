class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0, j = 0;

        while (j < t.length()) {
            while (i < s.length()) {
                if (s.charAt(i) == t.charAt(j)) {
                    j++;
                    if (j == t.length()) break;
                }
                i++;
            }
            if (i == s.length()) break;           
        }

        return t.length() - j ;
    }
}