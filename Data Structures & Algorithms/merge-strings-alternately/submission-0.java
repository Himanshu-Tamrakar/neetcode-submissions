class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        StringBuilder s = new StringBuilder();
        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            s.append(word1.charAt(i++));
            s.append(word2.charAt(j++));
        }

        while (i < n) {
            s.append(word1.charAt(i++));
        }

        while(j < m) {
            s.append(word2.charAt(j++));
        }

        return s.toString();

    }
}