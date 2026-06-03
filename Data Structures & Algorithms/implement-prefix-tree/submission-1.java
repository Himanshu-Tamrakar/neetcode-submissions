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
        Node x = root;

        for (char c: word.toCharArray()) {
            if (x.next[c] == null) {
                x.next[c] = new Node();
            }
            x = x.next[c];
        }
        x.word = true;
    }


    public boolean search(String word) {
        Node x = root;
        for (char c: word.toCharArray()) {
            if (x.next[c] == null) { 
                return false;
            }
            x = x.next[c];
        }
        return x.word;
    }

    public boolean startsWith(String prefix) {
      Node x = root;
      for (char c: prefix.toCharArray()) {
        if (x.next[c] == null) {
            return false;
        }
        x = x.next[c];
      }
      return true;
    }

 
}
