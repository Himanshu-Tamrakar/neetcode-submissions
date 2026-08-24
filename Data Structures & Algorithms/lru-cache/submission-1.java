class LRUCache {
    private class Node {
        int key;
        int val;
        Node prev, next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private int cap;
    private HashMap<Integer, Node> cache;
    private Node first;
    private Node last;

    public LRUCache(int capacity) {
        cap = capacity;
        cache = new HashMap<>();
        first = new Node(0, 0);
        last = new Node(0, 0);
        first.next = last;
        last.prev = first;
        
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        remove(node);
        insert(node);
        return node.val;
        
    }

   private void remove(Node node) {
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }

    private void insert(Node node) {
        Node prev = this.last.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.last;
        this.last.prev = node;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
        }

        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);

        if (cache.size() > cap) {
            Node lru = this.first.next;
            remove(lru);
            cache.remove(lru.key);
        }

    }
}
