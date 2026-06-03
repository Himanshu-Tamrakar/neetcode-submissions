class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int N = text1.length();
        int M = text2.length();

        int[][] dp = new int[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.max(
                        dp[i + 1][j],
                        dp[i][j + 1]
                    );
                }

            }
        }

        return dp[N][M];

    }
}
