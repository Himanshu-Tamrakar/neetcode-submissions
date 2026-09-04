class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int n = mat1.length;
        int m = mat2[0].length;
        int[][] res = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = calc(mat1, i, mat2, j);
            }
        }

        return res;
    }

    private int calc(int[][] mat1, int row, int[][] mat2, int col) {
        int sum = 0;
        int k = mat1[0].length; 
        
        for (int i = 0; i < k; i++) {
            sum += mat1[row][i] * mat2[i][col];
        }
        return sum;
    }
}
