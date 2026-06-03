class WordDictionary {
    private static final int R = 256;
    private static class Node {
        private boolean word = false;
        private Node[] next = new Node[R];
    }
    private Node root = new Node();

    public WordDictionary() {

    }

    public void addWord(String word) {
        root = addWord(root, word, 0);
    }

    private Node addWord(Node x, String key, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.word = true;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = addWord(x.next[c], key, d+1);
        return x;
    }

    public boolean search(String word) {
        Node x = search(root, word, 0);
        if (x == null) return false;
        return x.word;
    }

    private Node search(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) {
            return x;
        }

        char c = key.charAt(d);

        if (c == '.') {
            for(int i = 0; i < R; i++) {
                Node x1 = search(x.next[i], key, d+1);
                if (x1 != null) return x1;
            }
            return null;
        } else {
            return search(x.next[c], key, d+1);
        }
        
    }
}
