class StockSpanner {
    Stack<Integer> priceStack = new Stack<>();
    Stack<Integer> spanStack = new Stack<>();
    
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int span = 1;
        while (!priceStack.isEmpty() && priceStack.peek() <= price) {
            span += spanStack.pop();
            priceStack.pop();
        }
        priceStack.push(price);
        spanStack.push(span);
        return span;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */