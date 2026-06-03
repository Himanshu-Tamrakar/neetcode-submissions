class StockSpanner {
    Stack<Integer> stack = new Stack<>();
    
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        stack.push(price);
        Stack<Integer> temp = new Stack<>();
        int i = 0;
        while (!stack.isEmpty() && stack.peek() <= price) {
            temp.push(stack.pop());
            i++;
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        return i;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */