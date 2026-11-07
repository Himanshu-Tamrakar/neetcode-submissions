class Solution {
    public int numDistinct(String s, String t) {
        int[][] cache = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                cache[i][j] = -1;
            }
        }
        return helper(0, 0, s, t, cache);
    }

    private int helper(int i, int j, String s, String t, int[][] cache) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;

        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        int res = helper(i + 1, j, s, t, cache);

        if (s.charAt(i) == t.charAt(j)) {
            res += helper(i + 1, j + 1, s, t, cache);
        } 
        cache[i][j] = res;
        return cache[i][j];
    }
}
