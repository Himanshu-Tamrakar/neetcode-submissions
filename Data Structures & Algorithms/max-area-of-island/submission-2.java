class Solution {
    private int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // int size = dfs(grid, i, j);
                    int size = bfs(grid, i, j);
                    max = Math.max(max, size);
                }
            }
        }

        return max;
    }

    // private int dfs(int[][] grid, int r, int c) {
    //     if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
    //         return 0;
    //     }

    //     if (grid[r][c] == 0) {
    //         return 0;
    //     }

    //     grid[r][c] = 0;

    //     int top     =  dfs(grid, r - 1, c);
    //     int bottom  =  dfs(grid, r + 1, c);
    //     int left    =  dfs(grid, r, c - 1);
    //     int right   =  dfs(grid, r, c + 1);

    //     return 1 + top + bottom + left + right;

    // }

     private int bfs(int[][] grid, int r, int c) {
      

        Queue<int[]> q = new LinkedList<>();
        grid[r][c] = 0;
        q.add(new int[] {r, c});
        int res = 1;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            for (int[] direction: directions) {
                int nr = row + direction[0];
                int nc = col + direction[1];
                if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                    q.add(new int[] {nr, nc});
                    grid[nr][nc] = 0;
                    res++;
                }
            }
        }

        return res;
    }
}
