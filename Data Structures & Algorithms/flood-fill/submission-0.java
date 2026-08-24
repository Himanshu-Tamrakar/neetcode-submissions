class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] marked = new boolean[image.length][image[0].length];
        dfs(image, marked, sr, sc, color);
        return image;
    }

    private void dfs(int[][] image, boolean[][] marked, int r, int c, int color) {
        int rows = image.length;
        int cols = image[0].length;
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return;
        }

        int currColor = image[r][c];
        marked[r][c] = true;
        
        int[][] directions = new int[][] {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        for (int[] direction: directions) {
            int newR = r + direction[0];
            int newC = c + direction[1];
            if (newR >= 0 && newR < rows && newC >= 0 && newC < cols) {
                if (!marked[newR][newC] && image[newR][newC] == currColor) {
                    dfs(image, marked, newR, newC, color);
                }
            }
        }

        image[r][c] = color;
    }
}