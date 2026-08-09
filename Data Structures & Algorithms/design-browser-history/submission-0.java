class BrowserHistory {
    private class Node {
        String url;
        Node next;
        Node prev;
        public Node(String url) {
            this.url = url;
        }
    }

    private Node root;
    private Node curr;

    public BrowserHistory(String homepage) {
        this.visit(homepage);
    }
    
    public void visit(String url) {
        Node newNode = new Node(url);
        if (this.root == null) {
            this.root = this.curr = newNode; 
        } else {
            Node next = curr.next;
            curr.next = newNode;
            newNode.prev = curr;
            this.curr = newNode;

            if (next != null) {
                next.prev = null;
            }
        }
    }

    // neetcode -> google -> facebook -> linkedin
                                   
    // root                              curr

    public String back(int steps) {
        while (this.curr != null && steps > 0) {
            if (this.curr.prev == null) break;
            this.curr = this.curr.prev;
            steps--;
        }   
        return this.curr.url;
    }
    
    public String forward(int steps) {
        while (this.curr != null && steps > 0) {
            if (this.curr.next == null) break;
            this.curr = this.curr.next;
            steps--;
        }   
        return this.curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */