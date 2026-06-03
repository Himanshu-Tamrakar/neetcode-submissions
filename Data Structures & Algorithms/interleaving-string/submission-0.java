class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];

        return dfs(s1, s2, s3, memo, 0, 0);
    }

    private boolean dfs(String s1, String s2, String s3, Boolean[][] memo, int i, int j) {
        if (i == s1.length() && j == s2.length()) {
            return true;
        }

        if (memo[i][j] != null) return memo[i][j];

        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            res = dfs(s1, s2, s3, memo, i + 1, j);
        }

        if (!res && j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            res = dfs(s1, s2, s3, memo, i, j+1);
        }

        memo[i][j] = res;

        return memo[i][j];
    }
}
