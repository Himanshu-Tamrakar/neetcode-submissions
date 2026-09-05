class TicTacToe {
    private int[][] board;
    public TicTacToe(int n) {
        board = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        board[row][col] = player;
        if (checkRow(board, row, player) || 
            checkCol(board, col, player) || 
            checkDiagonal(board, player) || 
            checkAntiDiagonal(board, player) ) {
                return player;
            }

        return 0;
    }

    private boolean checkRow(int[][] board, int row, int player) {

        for (int col = 0; col < board.length; col++) {
            if (board[row][col] == 0 || board[row][col] != player) {
                return false;
            }
        }

        return true;
    }

    private boolean checkCol(int[][] board, int col, int player) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][col] == 0 || board[row][col] != player) {
                return false;
            }
        }

        return true;
    }

    private boolean checkDiagonal(int[][] board, int player) {
        int n = board.length;
        for (int row = 0; row < board.length; row++) {
            // check top left to bottom right 
            if (board[row][row] == 0 || board[row][row] != player) {
                return false;
            } 
        }
        return true;
    }

    private boolean checkAntiDiagonal(int[][] board, int player) {
        int n = board.length;
        for (int row = 0; row < board.length; row++) {
            // check top left to bottom right 
            if (board[row][n - row - 1] == 0 || board[row][n - row - 1] != player) {
                return false;
            } 
        }
        return true;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
