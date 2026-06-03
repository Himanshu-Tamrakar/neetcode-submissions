class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] memo = new int[n + 1][m + 1];
        for (int[] row: memo) Arrays.fill(row, -1);
        return dfs(word1, word2, memo, 0, 0);
    }

    private int dfs(String word1, String word2, int[][] memo, int i, int j) {
        if (i == word1.length()) return word2.length() - j;
        if (j == word2.length()) return word1.length() - i;

        if (memo[i][j] != -1) return memo[i][j];
        
        if (word1.charAt(i) == word2.charAt(j)) {
            return dfs(word1, word2, memo, i + 1, j + 1);
        }

        int res;
        int insert = dfs(word1, word2, memo, i, j + 1);
        int delete = dfs(word1, word2, memo, i + 1, j);
        int replace = dfs(word1, word2, memo, i + 1, j + 1);

        res = Math.min(insert, delete);
        res = Math.min(res, replace);
        memo[i][j] = res + 1;
        return memo[i][j];


    }
}
