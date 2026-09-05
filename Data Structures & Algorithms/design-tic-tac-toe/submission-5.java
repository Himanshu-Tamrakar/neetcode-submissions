class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        antiDiagonal = 0;
    }
    
    public int move(int row, int col, int player) {
        int currentPlayer = player == 1 ? 1 : -1;

        // update rows cols
        rows[row] += currentPlayer;
        cols[col] += currentPlayer;

        // update if diagonal
        if (row == col) {
            diagonal += currentPlayer;
        }

        // update if anti diagonal
        if (col == cols.length - row - 1) {
            antiDiagonal += currentPlayer;
        }

        int n = rows.length;
        if (Math.abs(rows[row]) == n || 
            Math.abs(cols[col]) == n || 
            Math.abs(diagonal) == n || 
            Math.abs(antiDiagonal) == n) {
            return player;
        }
        return 0;
    }

    
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */


// class TicTacToe {
//     private int[][] board;
//     public TicTacToe(int n) {
//         board = new int[n][n];
//     }
    
//     public int move(int row, int col, int player) {
//         int n = board.length;
//         board[row][col] = player;
//         if (checkRow(board, row, player) || 
//             checkCol(board, col, player) || 
//             (row == col && checkDiagonal(board, player)) || 
//             (col == n - row - 1 && checkAntiDiagonal(board, player)) ) {
//                 return player;
//             }

//         return 0;
//     }

//     private boolean checkRow(int[][] board, int row, int player) {

//         for (int col = 0; col < board.length; col++) {
//             if (board[row][col] == 0 || board[row][col] != player) {
//                 return false;
//             }
//         }

//         return true;
//     }

//     private boolean checkCol(int[][] board, int col, int player) {
//         for (int row = 0; row < board.length; row++) {
//             if (board[row][col] == 0 || board[row][col] != player) {
//                 return false;
//             }
//         }

//         return true;
//     }

//     private boolean checkDiagonal(int[][] board, int player) {
//         int n = board.length;
//         for (int row = 0; row < board.length; row++) {
//             // check top left to bottom right 
//             if (board[row][row] == 0 || board[row][row] != player) {
//                 return false;
//             } 
//         }
//         return true;
//     }

//     private boolean checkAntiDiagonal(int[][] board, int player) {
//         int n = board.length;
//         for (int row = 0; row < board.length; row++) {
//             // check top left to bottom right 
//             if (board[row][n - row - 1] == 0 || board[row][n - row - 1] != player) {
//                 return false;
//             } 
//         }
//         return true;
//     }
// }

// /**
//  * Your TicTacToe object will be instantiated and called as such:
//  * TicTacToe obj = new TicTacToe(n);
//  * int param_1 = obj.move(row,col,player);
//  */
