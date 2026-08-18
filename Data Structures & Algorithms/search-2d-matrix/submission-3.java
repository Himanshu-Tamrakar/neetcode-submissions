class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int searchInRow = -1;
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] <= target && matrix[i][c - 1] >= target) {
                searchInRow = i;
            }
        }

        if (searchInRow == -1) return false;

        int lo = 0;
        int hi = c-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[searchInRow][mid] < target) lo = mid + 1;
            else if (matrix[searchInRow][mid] > target) hi = mid - 1;
            else return true;
        }

        return false;
    }
}
