class Solution {
    private int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        return bfs(grid, q, fresh);
    }

    private int bfs(int[][] grid, Queue<int[]> q, int fresh) {
        if (fresh == 0) {
            return 0;
        }
        int minutes = 0;

        while (!q.isEmpty() && fresh > 0) {
            for (int i = q.size(); i > 0; i--) {
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];
                for (int[] direction: directions) {
                    int nr = row + direction[0];
                    int nc = col + direction[1];
                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                        fresh--;
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            minutes++;

        }
        return fresh == 0 ? minutes : -1;
    }
    
}
