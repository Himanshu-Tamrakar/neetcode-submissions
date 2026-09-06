class Solution {
    public void wiggleSort(int[] nums) {
        int i = 0; 
        int j = nums.length - 1;
        int idx = 1;
        int[] res = new int[nums.length];
        Arrays.sort(nums);

        while (i < j) {
            if (odd(idx)) {
                res[idx++] = nums[j--];
            } else {
                res[idx++] = nums[i++];
            }
        }
        res[0] = nums[i];
        for (int k = 0; k < nums.length; k++) {
            nums[k] = res[k];
        }
        
    }

    private boolean odd(int i) {
        return i % 2 == 0 ? false : true;
    }
}
