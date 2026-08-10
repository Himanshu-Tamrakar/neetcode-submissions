class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        this.q1 = new ArrayDeque<>();
        this.q2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        this.q1.offer(x);
    }
    
    public int pop() {
        while(q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int val = q1.poll();
        
        this.q1 = this.q2;
        this.q2 = new ArrayDeque<>();
        return val;
    }
    
    public int top() {
        while(q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int val = q1.poll();
        q2.offer(val);
        
        this.q1 = this.q2;
        this.q2 = new ArrayDeque<>();
        return val;
    }
    
    public boolean empty() {
        return this.q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */