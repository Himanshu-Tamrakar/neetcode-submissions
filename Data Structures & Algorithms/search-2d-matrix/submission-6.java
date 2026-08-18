class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        int lo = 0;
        int hi = r * c - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int midR = mid / c;
            int midC = mid % c;

            if (matrix[midR][midC] < target) {
                lo = mid + 1;
            } else if (matrix[midR][midC] > target) {
                hi = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    // n + log(m); n = row, n = colunms
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int searchInRow = -1;
//         int r = matrix.length;
//         int c = matrix[0].length;

//         // find which row to seach
//         for (int i = 0; i < r; i++) {
//             if (matrix[i][0] <= target && matrix[i][c - 1] >= target) {
//                 searchInRow = i;
//             }
//         }

//         // if none row
//         if (searchInRow == -1) return false;

//         // apply binary search
//         int lo = 0;
//         int hi = c-1;
//         while (lo <= hi) {
//             int mid = lo + (hi - lo) / 2;
//             if (matrix[searchInRow][mid] < target) lo = mid + 1;
//             else if (matrix[searchInRow][mid] > target) hi = mid - 1;
//             else return true;
//         }

//         return false;
//     }
}
