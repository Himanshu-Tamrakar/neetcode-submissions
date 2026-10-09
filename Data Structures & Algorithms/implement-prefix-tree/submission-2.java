class PrefixTree {
    private static final int R = 256; // Extended Asci
    private class Node {
        boolean isWord;
        Node[] next;

        public Node() {
            this.isWord = isWord;
            next = new Node[R];
        }
    }
    private Node root;

    public PrefixTree() {
         
    }

    public void insert(String word) {
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

    public boolean search(String word) {
        Node x = search(this.root, word, 0);
        if (x == null) {
            return false;
        }
        return true;
    }

    private Node search(Node x, String word, int d) {
        if (x == null) {
            return x;
        }

        if (d == word.length()) {
            return x.isWord ? x : null;
        }

        char ch = word.charAt(d);
        return search(x.next[ch], word, d + 1);
    }

    public boolean startsWith(String prefix) {
        Node x = startsWith(this.root, prefix, 0);
        if (x == null) return false;
        return true;
    }

    private Node startsWith(Node x, String prefix, int d) {
        if (x == null) {
            return null;
        }

        if (d == prefix.length()) {
            return x;
        }
        char ch = prefix.charAt(d);

        return startsWith(x.next[ch], prefix, d + 1);
    }
}
