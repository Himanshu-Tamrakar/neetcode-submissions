class Solution {
    private int[][] directions = new int[][] {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}
    };
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length-1][grid[0].length - 1] == 1) {
            return -1;
        }

        int[][] distTo = new int[grid.length][grid[0].length];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        // grid[0][0] = 1;
        distTo[0][0] = 1;

        return bfs(grid, distTo, q);
    }

    private int bfs(int[][] grid, int[][] distTo, Queue<int[]> q) {
        
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];    
                if (row == (grid.length - 1) && col == (grid[0].length - 1)) return distTo[row][col];

                for (int[] direction: directions) {
                    int nr = row + direction[0];
                    int nc = col + direction[1];
                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 0) {
                        grid[nr][nc] = 1; 
                        distTo[nr][nc] = distTo[row][col] + 1;
                        q.offer(new int[] {nr, nc});
                    }
                }
            }
        }

        return distTo[grid.length - 1][grid[0].length - 1] != 0 ? distTo[grid.length - 1][grid[0].length - 1] : -1;

    }
}