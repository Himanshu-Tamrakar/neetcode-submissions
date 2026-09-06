class ZigzagIterator {
    private int idx = 0;
    private int i;
    private int j;
    private List<Integer> v1;
    private List<Integer> v2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {        
        this.idx = 0;
        this.i = 0;
        this.j = 0;
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        if (i >= this.v1.size()) {
            return this.v2.get(j++);
        }

        if (j >= this.v2.size()) {
            return this.v1.get(i++);
        }

        int val = -1;
        if (idx == 0) {
            val = this.v1.get(i++);
        } else {
            val = this.v2.get(j++);
        }

        idx = (idx + 1) % 2;
        return val;
    }

    public boolean hasNext() {
        return i < this.v1.size() || j < this.v2.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
