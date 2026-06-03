class FreqStack {
    private Map<Integer, Integer> count;
    private int maxCnt = 0;
    private List<Stack<Integer>> freqList; 
    public FreqStack() {
        count = new HashMap<>();
        freqList = new ArrayList();
        freqList.add(new Stack<>());
    }
    
    public void push(int val) {
        int freq = count.getOrDefault(val, 0) + 1;
        count.put(val, freq);
        if (freq == freqList.size()) {
            freqList.add(new Stack<>());
        }
        freqList.get(freq).push(val);
    }
    
    public int pop() {
        Stack<Integer> topStack = freqList.get(freqList.size() - 1);
        int res = topStack.pop();
        count.put(res, count.get(res) - 1);
        if (topStack.isEmpty()) {
            freqList.remove(freqList.size() - 1);
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */