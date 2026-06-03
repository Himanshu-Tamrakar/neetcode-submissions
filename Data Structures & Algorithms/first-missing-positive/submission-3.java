class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || (nums[i] < i && nums[i] == nums[nums[i] - 1]) || nums[i] >= n || nums[i] == (i+1)) continue;
            if (nums[i] == nums[nums[i] - 1]) continue;
            
            int k = nums[i] - 1;
            if (k >= n) continue;
            swap(nums, i, k);
            i--;


        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != (i+1)) return i + 1;
        }

        return n + 1;

        
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}