class FirstUnique {
    private Map<Integer, Integer> freq;
    private List<Integer> q;
    private int i;
    

    public FirstUnique(int[] nums) {
        freq = new HashMap<>();
        q = new LinkedList<>();
        i = 0;

        for (int num: nums) {
            add(num);
        }
    }
    
    public int showFirstUnique() {
        while (i < q.size() && freq.get(q.get(i)) > 1) {
            i++;
        }

        return i == q.size() ? -1 : q.get(i);
    }
    
    public void add(int value) {
        freq.put(value, freq.getOrDefault(value, 0) + 1);
        q.add(value);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
