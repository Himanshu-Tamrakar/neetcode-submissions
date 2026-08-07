class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        int cnt = 0;
        while(i <= j) {
            if (nums[i] == val) {
                cnt++;
                exch(nums, i, j);
                j--;

                if (nums[i] != val) {
                    i++;
                }
            } else {
                i++;
            }
            
        }

        return nums.length - cnt;
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}