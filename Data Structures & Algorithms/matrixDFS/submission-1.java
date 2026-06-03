class Solution {
    private boolean[][] visit;

    public int countPaths(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        visit = new boolean[r][c];
        return countPath(grid, 0, 0);
    }

    private int countPath(int[][] grid, int i, int j) {
        int r = grid.length;
        int c = grid[0].length;
        if (i < 0 || i == r || j < 0 || j == c) return 0;
        if (grid[i][j] == 1) return 0;
        if (visit[i][j]) return 0;
        if (i == r-1 && j == c-1) return 1;

        visit[i][j] = true;

        int count = 0;
        count += countPath(grid, i+1, j);
        count += countPath(grid, i-1, j);
        count += countPath(grid, i, j+1);
        count += countPath(grid, i, j-1);

        visit[i][j] = false;
        return count;
    }

    


}
