class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {   
        stack2.push(x); 
    }
    
    public int pop() {
        if (stack1.isEmpty()) {
            while(!stack2.isEmpty()) stack1.push(stack2.pop());
        }

        return stack1.pop();
    }
    
    public int peek() {
        if (stack1.isEmpty()) {
            while(!stack2.isEmpty()) stack1.push(stack2.pop());
        }

        return stack1.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */