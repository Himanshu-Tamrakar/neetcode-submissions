class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        this.q1 = new ArrayDeque<>();
        this.q2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        this.q2.offer(x);
        while (!this.q1.isEmpty()) {
            this.q2.offer(this.q1.poll());
        }
        Queue<Integer> temp = this.q1;
        this.q1 = this.q2;
        this.q2 = temp;
    }
    
    public int pop() {
        return this.q1.poll();
    }
    
    public int top() {
        return this.q1.peek();
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