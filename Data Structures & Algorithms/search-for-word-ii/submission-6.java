
class Trie {
    private static final int R = 256;
    private class Node {
        boolean isWord;
        Node[] next;
        public Node() {
            next = new Node[R];
        }
    }
    public Node root;

    private void insert(String word) {
        this.root = insert(this.root, word, 0);
    }
    private Node insert(Node x, String word, int d) {
        if (x == null) {
            x = new Node();
        }

        if (d == word.length()) {
            x.isWord = true;
            return x;
        }

        char ch = word.charAt(d);
        x.next[ch] = insert(x.next[ch], word, d + 1);
        return x;
    }
}


class Solution {
    private int ROWS;
    private int COLS;
    private Set<String> set;
    private Trie trie;
    private Set<String> res;
    private boolean[][] visit;
    

    public List<String> findWords(char[][] board, String[] words) {
        ROWS = board.length;
        COLS = board[0].length;
        set = new HashSet<>();
        trie = new Trie();
        res = new HashSet<>();
        visit = new boolean[ROWS][COLS];

        for (String word: words) {
            set.add(word);
            trie.insert(word);
        }
        

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                collect(board, i, j, trie.root, new StringBuilder());
            }
        }
        return new ArrayList<>(res);
    }

    private void collect(char[][] board, int r, int c, Trie.Node x, StringBuilder word) {
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || visit[r][c] || x.next[board[r][c]] == null) {
            return;
        }

        visit[r][c] = true;
        word.append(board[r][c]);
        x = x.next[board[r][c]];
        if (x.isWord) {
            res.add(word.toString());
        }

        int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] direction: directions) {
            int newR = r + direction[0];
            int newC = c + direction[1];
            collect(board, newR, newC, x, word);
          
        }
        word.deleteCharAt(word.length() - 1);
        visit[r][c] = false;
    }

    
}
