class LRUCache {
    private class Node {
        int key, val;
        Node prev, next;
        public Node(int k, int v) {
            key = k;
            val = v;
        }
    }
    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void insert(Node node) {
        Node lastReadNode = tail.prev;
        lastReadNode.next = node;
        node.prev = lastReadNode;
        node.next = tail;
        tail.prev = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
        } 

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);
        if (map.size() > this.capacity) {
            Node lru = head.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
