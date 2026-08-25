class Solution {
    private int[][] directions = new int[][] {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}
    };
    public int shortestPathBinaryMatrix(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        if (grid[0][0] == 1 || grid[R-1][C - 1] == 1) {
            return -1;
        }

        boolean[][] visit = new boolean[R][C];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 1});
        visit[0][0] = true;

        return bfs(grid, visit, q);
    }

    private int bfs(int[][] grid, boolean[][] visit, Queue<int[]> q) {
        int R = grid.length;
        int C = grid[0].length;
        
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];
                int dist = cell[2];

                if (row == (R - 1) && col == (C - 1)) return dist;

                for (int[] d: directions) {
                    int nr = row + d[0];
                    int nc = col + d[1];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && grid[nr][nc] == 0 && !visit[nr][nc]) {
                        visit[nr][nc] = true;
                        q.offer(new int[] {nr, nc, dist + 1});
                    }
                }
            }
        }
        return -1;
    }
}