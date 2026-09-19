class NumMatrix {
    private int[][] prefix;
    public NumMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        this.prefix = new int[r + 1][c + 1];

        for (int i = 0; i < r; i++) {
            int prefixSum = 0;
            for (int j = 0; j < c; j++) {
                prefixSum += matrix[i][j];
                int above = this.prefix[i][j + 1];
                this.prefix[i + 1][j + 1] = prefixSum + above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;
        int bottomRight  = this.prefix[row2][col2];
        int above = this.prefix[row1 - 1][col2];
        int left = this.prefix[row2][col1 - 1];
        int topLeft = this.prefix[row1-1][col1-1];
        return bottomRight  - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */