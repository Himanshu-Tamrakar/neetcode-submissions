class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        // memo[m - 1][n - 1] = 1;
        return dfs(m, n, 0, 0, memo);
    }

    private int dfs(int m, int n, int r, int c, int[][] memo) {
        if (r >= m || c >= n) {
            return 0;
        }

        if (r == (m - 1) && c == (n - 1)) {
            return 1;
        }

        if (memo[r][c] != -1) {
            return memo[r][c];
        }

        memo[r][c] = dfs(m, n, r + 1, c, memo) + dfs(m, n, r, c + 1, memo);

        return memo[r][c];


    }
}
