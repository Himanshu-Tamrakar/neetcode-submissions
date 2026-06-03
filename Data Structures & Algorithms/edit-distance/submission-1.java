class Solution {

     public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][m] = n - i;
        }

        for (int j = 0; j <= m; j++) {
            dp[n][j] = m - j;
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    int res;
                    int insert = dp[i][j + 1];
                    int delete = dp[i + 1][j];
                    int replace = dp[i + 1][j + 1];
                    res = Math.min(insert, delete);
                    res = Math.min(res, replace);
                    dp[i][j] = res + 1;
                }

            }
        }

        return dp[0][0];
    }

    // public int minDistance(String word1, String word2) {
    //     int n = word1.length();
    //     int m = word2.length();
    //     int[][] memo = new int[n][m];
    //     for (int[] row: memo) Arrays.fill(row, -1);
    //     return dfs(word1, word2, memo, 0, 0);
    // }

    // private int dfs(String word1, String word2, int[][] memo, int i, int j) {
    //     if (i == word1.length()) return word2.length() - j;
    //     if (j == word2.length()) return word1.length() - i;

    //     if (memo[i][j] != -1) return memo[i][j];
        
    //     if (word1.charAt(i) == word2.charAt(j)) {
    //         return dfs(word1, word2, memo, i + 1, j + 1);
    //     }

    //     int res;
    //     int insert = dfs(word1, word2, memo, i, j + 1);
    //     int delete = dfs(word1, word2, memo, i + 1, j);
    //     int replace = dfs(word1, word2, memo, i + 1, j + 1);

    //     res = Math.min(insert, delete);
    //     res = Math.min(res, replace);
    //     memo[i][j] = res + 1;
    //     return memo[i][j];
    // }
}
