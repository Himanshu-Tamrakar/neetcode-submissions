class Solution {
    private static final int R = 256;
    private static class Node {
        private int index = -1;
        private Node[] next = new Node[R];
    }
    private Node root = new Node();
    
    private char[][] board;
    private String[] words;
    private boolean[][] visit;
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.words = words;
        List<String> res = new ArrayList();
        for (int i = 0; i < words.length; i++) {
            insert(words[i], i);
        }
        
        
        int m = board.length;
        int n = board[0].length;
        visit = new boolean[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                
                dfs(r, c, root, res);
            }
        }
        return res;
    }

    private void dfs(int i, int j, Node x, List<String> res) {
        if (x == null) return;
        if (x.index != -1) {
            res.add(words[x.index]);
            x.index = -1;
        }
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) return;
        if (visit[i][j]) return;

        visit[i][j] = true;

        if (x.next[board[i][j]] != null) {
            
                dfs(i+1, j, x.next[board[i][j]], res);

                dfs(i-1, j, x.next[board[i][j]], res);

                dfs(i, j+1, x.next[board[i][j]], res);

                dfs(i, j-1, x.next[board[i][j]], res);
        }
        visit[i][j] = false;
    }

    private void insert(String key, int index) {
        root = insert(root, key, index, 0);
    }

    private Node insert(Node x, String key, int index, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.index = index;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = insert(x.next[c], key, index, d+1);
        return x;
    }
}
