class MinStack {

    private Deque<Integer> stack;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        min = Math.min(min, val);
    }
    
    public void pop() {
        int val = stack.pop();

        if (val == min) {
            min = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek(); 
            for (int v: stack) {
                min = Math.min(min, v);
            }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return this.min;
    }
}
