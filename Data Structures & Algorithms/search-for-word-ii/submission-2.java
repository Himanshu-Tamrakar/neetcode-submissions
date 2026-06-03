class Solution {
    
    public List<String> findWords(char[][] board, String[] words) {
    
        List<String> res = new ArrayList();
        int m = board.length;
        int n = board[0].length;
        
        for (String word: words) {
            boolean flag = false;
            for (int i = 0; i < m && !flag; i++) {
                flag = false;
                for (int j = 0; j < n; j++) {

                    if (board[i][j] != word.charAt(0)) continue;
                    if (backtracking(board, i, j, word, 0)) {

                        res.add(word);
                        flag = true;
                        break;

                    }

                }
            }
        }

    
        return res;
    }

    private boolean backtracking(char[][] board, int i, int j, String word, int d) {
        if (d == word.length()) return true;
        
        if (i < 0 || i == board.length || j < 0 || j == board[0].length) return false;

        if (board[i][j] != word.charAt(d)) return false;

        

        board[i][j] = '#';

        boolean res = backtracking(board, i+1, j, word, d+1) ||
                      backtracking(board, i-1, j, word, d+1) ||  
                      backtracking(board, i, j+1, word, d+1) ||
                      backtracking(board, i, j-1, word, d+1);

        board[i][j] = word.charAt(d);
        return res;

         
    }

 
}
