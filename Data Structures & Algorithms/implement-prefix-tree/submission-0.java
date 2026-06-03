class PrefixTree {
    private static final int R = 256;
    private static class Node {
        private boolean word = false;
        private Node[] next = new Node[R];
    }
    private Node root = new Node();
    public PrefixTree() {
         
    }

    public void insert(String word) {
        root = insert(root, word, 0);
    }

    private Node insert(Node x, String key, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.word = true;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = insert(x.next[c], key, d+1);
        return x;
    }

    public boolean search(String word) {
        Node x = search(root, word, 0);
        if (x == null) return false;
        return x.word;
    }

    private Node search(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return search(x.next[c], key, d+1);
    }

    public boolean startsWith(String prefix) {
        Node x = startsWith(root, prefix, 0);
        if (x == null) return false;
        return true;
    }

    private Node startsWith(Node x, String prefix, int d) {
        if (x == null) return null;
        if (d == prefix.length()) {
            return x;
        }
        char c = prefix.charAt(d);
        return startsWith(x.next[c], prefix, d+1);
    }
}
