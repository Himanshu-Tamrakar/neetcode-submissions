class Solution {
    public int numDistinct(String s, String t) {

        int N = s.length();
        int M = t.length();
        int[][] memo = new int[N][M];
        for (int[] row: memo) Arrays.fill(row, -1);

        return dfs(s, t, memo, 0, 0);
    }

    private int dfs(String s, String t, int[][] memo, int i, int j) {
        if (j == t.length()) {
            return 1;
        }

        if (i == s.length()) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            memo[i][j] = dfs(s, t, memo, i + 1, j + 1) + dfs(s, t, memo, i + 1, j);
        } else {
            memo[i][j] = dfs(s, t, memo, i + 1, j);
        }

        return memo[i][j];
        
    }
}
