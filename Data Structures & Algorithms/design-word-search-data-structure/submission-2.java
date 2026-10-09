class WordDictionary {
    private static final int R = 256;
    private class Node {
        boolean isWord;
        Node[] next;
        public Node() {
            next = new Node[R];
        }
    }
    private Node root;
    public WordDictionary() {

    }

    public void addWord(String word) {
        this.root = addWord(this.root, word, 0);
    }

    private Node addWord(Node x, String word, int d) {
        if (x == null) {
            x = new Node();
        }

        if (d == word.length()) {
            x.isWord = true;
            return x;
        }

        char ch = word.charAt(d);
        x.next[ch] = addWord(x.next[ch], word, d + 1);
        return x;
    }

    public boolean search(String word) {
        return search(this.root, word, 0);
    }

    private boolean search(Node x, String word, int d) {
        if (x == null) {
            return false;
        }
        if (d == word.length()) {
            return x.isWord;
        }
        char ch = word.charAt(d);

        if (ch == '.') {
            boolean res = false;
            for (char c = 0; c < R; c++) {
                if (search(x.next[c], word, d + 1)) {
                    return true;
                }
            }
            return false;
            
        } else {
            return search(x.next[ch], word, d + 1);
        }
    }
}
