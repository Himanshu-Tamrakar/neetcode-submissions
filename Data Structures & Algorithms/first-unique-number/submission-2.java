class FirstUnique {
    private Map<Integer, Integer> freq;
    private Queue<Integer> q;

    public FirstUnique(int[] nums) {
        freq = new HashMap<>();
        q = new LinkedList<>();

        for (int num: nums) {
            add(num);
        }
    }
    
    public int showFirstUnique() {
        while (!q.isEmpty() && freq.get(q.peek()) > 1) {
            q.poll();
        }

        return q.isEmpty() ? -1 : q.peek();
    }
    
    public void add(int value) {
        freq.put(value, freq.getOrDefault(value, 0) + 1);
        q.offer(value);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
