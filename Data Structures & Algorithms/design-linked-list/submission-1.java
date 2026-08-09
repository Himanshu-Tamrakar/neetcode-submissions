class MyLinkedList {
    private Node head;
    private int sz;
    private class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    public MyLinkedList() {
        this.head = null;
        this.sz = 0;
    }

    public int get(int index) {
        if (index >= sz)
            return -1;
        if (index >= sz) 
            return -1;

        Node first = this.head;
        for (int i = 0; i < index; i++) {
            first = first.next;
        }
        return first.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = this.head;
        this.head = newNode;
        sz++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node curr = this.head;
                
        for (int i = 1; i < sz; i++) {
            curr = curr.next;
        }

        curr.next = newNode;
        sz++;
    }

    public void addAtIndex(int index, int val) {
        if (index > sz)
            return;

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == sz) {
            addAtTail(val);
            return;
        }

        Node curr = this.head;
      
        for (int i = 1; i < index; i++) {
            curr = curr.next;
        }

        Node next = curr.next;
        curr.next = new Node(val);
        curr.next.next = next;
        sz++;
    }

    public void deleteAtIndex(int index) {
        if (index >= sz)
            return;
        if (index < 0)
            return;

        if (index == 0) {
            this.head = this.head.next;
            return;
        }
        
        Node first = this.head;
        for (int i = 1; i < index; i++) {
            first = first.next;
        }
        
        first.next = first.next.next;
        sz--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */