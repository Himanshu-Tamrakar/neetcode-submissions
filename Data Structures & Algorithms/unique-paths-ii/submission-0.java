class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        int[][] memo = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                memo[i][j] = -1;
            }
        }
        return dfs(obstacleGrid, 0, 0, memo);
        
    }

    private int dfs(int[][] grid, int r, int c, int[][] memo) {
        if (r >= grid.length || c >= grid[0].length) {
            return 0;
        }

        if (grid[r][c] == 1) {
            return 0;
        }
        if (memo[r][c] != -1) {
            return memo[r][c];
        }

        if (r == (grid.length - 1) && c == (grid[0].length - 1)) {
            return 1;
        }

        memo[r][c] = dfs(grid, r + 1, c, memo) + dfs(grid, r, c + 1, memo);
        return memo[r][c];
    }
}