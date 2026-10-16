class Solution {
  
    public int swimInWater(int[][] grid) {
       

        PriorityQueue<int[]> min  = new PriorityQueue<>((c1, c2) -> Integer.compare(c1[2], c2[2]));
        // row, col, elevation
        int[] start = new int[] {0, 0, grid[0][0]};
        min.offer(start);

        boolean[][] visit = new boolean[grid.length][grid[0].length];
        
        while (!min.isEmpty()) {
            int[] curr = min.poll();
            int r = curr[0];
            int c = curr[1];
            int weight = curr[2];
            if (r == grid.length - 1 && c == grid[0].length-1) { 
                return weight;
            }

            if (visit[r][c]) {
                continue;
            }

            visit[r][c] = true;
            int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 

            for (int[] direction: directions) {
                int newR = r + direction[0];
                int newC = c + direction[1];

                if (newR >= 0 && newC >= 0 && newR < grid.length && newC < grid.length && !visit[newR][newC]) {
                        min.offer(new int[] { newR, newC, Math.max(weight, grid[newR][newC]) });
                }
                
            }
        }

        return grid[grid.length][grid[0].length];
    }
}
