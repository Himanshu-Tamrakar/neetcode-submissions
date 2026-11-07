public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(
                        dp[i][j + 1],
                        dp[i + 1][j]
                    );
                }
            }
        }
        return dp[0][0];
    }

    // public int longestCommonSubsequence(String text1, String text2) {
    //     int N = text1.length();
    //     int M = text2.length();
    //     int[][] dp = new int[N + 1][M + 1];
    //     for (int i = 0; i < N; i++) {
    //         for (int j = 0; j < M; j++) {
    //             if (text1.charAt(i) == text2.charAt(j)) {
    //                 dp[i+1][j+1] = 1 + dp[i][j];
    //             } else {
    //                 dp[i+1][j+1] = Math.max(
    //                     dp[i + 1][j],
    //                     dp[i][j + 1]
    //                 );
    //             }
    //         }
    //     }
    //     return dp[N][M];
    // }

    public int longestCommonSubsequence1(String text1, String text2) {
        int[][] cache = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                cache[i][j] = -1;
            }
        }
        return helper(text1, 0, text2, 0, cache);
    }

    private int helper(String text1, int i, String text2, int j, int[][] cache) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }

        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            cache[i][j] = 1 + helper(text1, i + 1, text2, j + 1, cache);
        } else {
            cache[i][j] = Math.max(
                helper(text1, i + 1, text2, j, cache),
                helper(text1, i, text2, j + 1, cache)
            );
        }
        return cache[i][j];
    }
}