class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if ((s1.length() + s2.length()) != s3.length()) {
            return false;
        }

        Boolean[][] cache = new Boolean[s1.length() + 1][s2.length() + 1];

        return dfs(s1, s2, s3, 0, 0, cache);
    }

    private boolean dfs(String s1, String s2, String s3, int i, int j, Boolean[][] cache) {
        if (i == s1.length() && j == s2.length()) {
            return true;
        }

        if (cache[i][j] != null) {
            return cache[i][j];
        }

        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i+j)) {
            res = dfs(s1, s2, s3, i + 1, j, cache);
        } 
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            res = res || dfs(s1, s2, s3, i, j + 1, cache);
        }
        cache[i][j] = res;
        return cache[i][j];
    }
}
