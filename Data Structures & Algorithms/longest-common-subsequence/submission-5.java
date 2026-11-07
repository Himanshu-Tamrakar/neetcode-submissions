public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
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