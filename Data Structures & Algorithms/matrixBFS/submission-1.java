class Solution {
    public int shortestPath(int[][] grid) {
        ArrayDeque<int[]> queue = new ArrayDeque<int[]>();

        int r = grid.length;
        int c = grid[0].length;

        queue.add(new int[]{0, 0});
        grid[0][0] = 1; // marked once visited
        int len = 0;
        while(!queue.isEmpty()) {
            int sz = queue.size();
            for (int l = 0; l < sz; l++) {
                int[] pos = queue.poll();
                int i = pos[0];
                int j = pos[1];

                if (i == r-1 && j == c-1) return len;

                int[][] movements = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

                for (int k = 0; k < movements.length; k++) {
                    int[] movement = movements[k];
                    int dr = movement[0];
                    int dc = movement[1];

                    if (i+dr < 0 || i+dr == r || j+dc < 0 || j+dc == c) continue;
                    if (grid[i+dr][j+dc] == 1) continue;

                    queue.add(new int[] {i+dr, j+dc});
                
                    grid[i+dr][j+dc] = 1;
                }

            }
            len++;
        }

        return -1;

    }
}
