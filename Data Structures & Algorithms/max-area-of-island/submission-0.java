class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j);
                    max = Math.max(max, size);
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return 0;
        }

        if (grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;

        int top     =  dfs(grid, r - 1, c);
        int bottom  =  dfs(grid, r + 1, c);
        int left    =  dfs(grid, r, c - 1);
        int right   =  dfs(grid, r, c + 1);

        return 1 + top + bottom + left + right;

    }
}
