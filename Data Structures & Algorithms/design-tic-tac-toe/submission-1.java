class TicTacToe {
    private int[][] board;
    public TicTacToe(int n) {
        board = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        board[row][col] = player;
        if (checkRow(board, row, player) == player) {
            return player;
        } else if (checkCol(board, col, player) == player) {
            return player;
        } else if (checkDiagonal(board, player) == player) {
            return player;
        } else {
            return 0;
        }
        
    }

    private int checkRow(int[][] board, int row, int player) {
        boolean winner = true;

        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == 0 || board[row][i] != player) {
                winner = false;
                break;
            }
        }

        return winner ? player : 0;
    }

    private int checkCol(int[][] board, int col, int player) {
        boolean winner = true;

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 0 || board[i][col] != player) {
                winner = false;
                break;
            }
        }

        return winner ? player : 0;
    }

    private int checkDiagonal(int[][] board, int player) {
        boolean winner = true;

        for (int i = 0; i < board.length; i++) {
            // check top left to bottom right 
            if (board[i][i] == 0 || board[i][i] != player) {
                winner = false;
                break;
            } 
        }

        if (winner) {
            return player;
        }

        winner = true;
        int n = board.length - 1;

        for (int i = 0; i < board.length; i++) {
            // & bottom left to top right
            if (board[n][i] == 0 || board[n][i] != player) {
                winner = false;
                break;
            } 
            n--;
        }
        
        return winner ? player : 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
