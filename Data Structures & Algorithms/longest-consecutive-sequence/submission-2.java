class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int res = 0;

        Arrays.sort(nums);
        int i = 1;
        int cnt = 1;
        while (i < nums.length) {
            if (nums[i] == (nums[i-1] + 1)) {
                cnt++;
            } else if (nums[i] == nums[i-1]) {
              
            } else {
                cnt = 1;
            }
            res = Math.max(res, cnt);
            i++;
        }
        return res;
        
    }
}
