class MyStack {
    Queue<Integer> queue = new LinkedList<>();
    Queue<Integer> queue1 = new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        queue.offer(x);
    }
    
    public int pop() {
        while(queue.size() > 1) {
            queue1.offer(queue.poll());
        }
        int res = queue.poll();
        queue = queue1;
        queue1 = new LinkedList<>();
        return res;
    }
    
    public int top() {
        while(queue.size() > 1) {
            queue1.offer(queue.poll());
        }
        int res = queue.poll();
        queue1.offer(res);
        queue = queue1;
        queue1 = new LinkedList<>();
        return res;
        
    }
    
    public boolean empty() {
        return queue.isEmpty();
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