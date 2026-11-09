public class Solution {
    private int[][] dp;

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(0, n - 1, s);
    }

    private int dfs(int i, int j, String s) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = dfs(i + 1, j - 1, s) + 2;
        } else {
            dp[i][j] = Math.max(dfs(i + 1, j, s), dfs(i, j - 1, s));
        }

        return dp[i][j];
    }
}