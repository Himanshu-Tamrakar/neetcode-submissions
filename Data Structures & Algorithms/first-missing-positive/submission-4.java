class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) nums[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val == 0 || val > n) continue;

            
            if (nums[val - 1] > 0)
                nums[val - 1] *= -1; 
            else if (nums[val - 1] == 0) {
                nums[val - 1] = -(n + 1);
            }            
            
        }

        for (int n1: nums) System.out.print(n1 + " ");
        System.out.println();

        for (int i = 1; i <= n; i++) {
            int val = nums[i-1];
            if (val >= 0) return i;
        }

        return n + 1;

        
    }

 
}