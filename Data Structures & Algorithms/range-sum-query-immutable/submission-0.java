class NumArray {
    private int[] prefix;
    public NumArray(int[] nums) {
        this.prefix = new int[nums.length];
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            this.prefix[i] = total;
        }
    }
    
    public int sumRange(int left, int right) {
        if (left == 0) {
            return this.prefix[right];
        } else {
            return this.prefix[right] - this.prefix[left-1];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */