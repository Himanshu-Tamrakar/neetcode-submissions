class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int sum = 0;
        int cnt = 0;
        int L = 0;
        for (int R = 0; R < nums.length; R++) {
            sum += nums[R];
            
            if ((R - L + 1)  == k) {
                if (sum >= threshold * k) cnt++;
                sum -= nums[L++];
            }   
        }

        return cnt;

    }
}