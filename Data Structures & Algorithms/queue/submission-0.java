class Deque {
    private Node first, last;
    private class Node {
        private int val;
        private Node prev, next;

        public Node(int v) {
            val = v;
        }
    }

    public Deque() {

    }

    public boolean isEmpty() {
        if (first == null) return true;
        return false;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = last = newNode;
            return;
        }
        newNode.prev = last;
        last.next = newNode;
        last = last.next;
    }

    public void appendleft(int value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = last = newNode;
            return;
        }
        newNode.next = first;
        first.prev = newNode;
        first = first.prev;
    }

    public int pop() {
        if (isEmpty()) return -1;
        int val = last.val;
        if (first == last) { 
            first = last = null;
            return val;
        }
        last = last.prev;
        last.next = null;
        return val;
    }

    public int popleft() {
        if (isEmpty()) return -1;
        int val = first.val;
        if (first == last) { 
            first = last = null;
            return val;
        }
        first = first.next;
        first.prev = null;
        return val;
    }
}
