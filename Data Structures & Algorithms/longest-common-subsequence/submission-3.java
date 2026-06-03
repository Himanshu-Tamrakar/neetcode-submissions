class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int N = text1.length();
        int M = text2.length();

        int[] dp = new int[M + 1];
        // top down dp
        for (int i = 0; i < N; i++) {
            int[] dpNew = new int[M + 1];
            for (int j = 0; j < M; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dpNew[j + 1] = 1 + dp[j];
                } else {
                    dpNew[j + 1] = Math.max(
                        dp[j + 1],
                        dpNew[j]
                    );
                }
            }
            dp = dpNew;
        }

        return dp[M];

    }

    // public int longestCommonSubsequence(String text1, String text2) {
    //     int N = text1.length();
    //     int M = text2.length();

    //     int[][] dp = new int[N + 1][M + 1];

    //     for (int i = 0; i < N; i++) {
    //         for (int j = 0; j < M; j++) {

    //             if (text1.charAt(i) == text2.charAt(j)) {
    //                 dp[i + 1][j + 1] = 1 + dp[i][j];
    //             } else {
    //                 dp[i + 1][j + 1] = Math.max(
    //                     dp[i + 1][j],
    //                     dp[i][j + 1]
    //                 );
    //             }

    //         }
    //     }

    //     return dp[N][M];

    // }

    // public int longestCommonSubsequence(String text1, String text2) {
    //     int N = text1.length();
    //     int M = text2.length();
    //     int[][] memo = new int[N][M];
    //     for (int[] row: memo) Arrays.fill(row, -1);

    //     return dfs(text1, text2, memo, 0, 0);
    // }

    // private int dfs(String text1, String text2, int[][] memo, int i, int j) {
    //     if (i == text1.length() || j == text2.length()) return 0;
    //     if (memo[i][j] != -1) return memo[i][j];

    //     if (text1.charAt(i) == text2.charAt(j)) {
    //         memo[i][j] = 1 + dfs(text1, text2, memo, i + 1, j + 1);
    //     } else {
    //         memo[i][j] = Math.max(
    //             dfs(text1, text2, memo, i + 1, j),
    //             dfs(text1, text2, memo, i, j + 1)
    //         );
    //     }
    //     return memo[i][j];
    // }


}
