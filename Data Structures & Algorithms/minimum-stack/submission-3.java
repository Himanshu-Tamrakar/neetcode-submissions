class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        int min = val;
        if (!minStack.isEmpty()){
            min = Math.min(min, minStack.peek());
        } 
        minStack.push(min);
    }
    
    public void pop() {
        if (stack.isEmpty()) return;

        stack.pop();
        minStack.pop();  
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
