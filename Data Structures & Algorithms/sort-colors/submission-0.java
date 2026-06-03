class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];

        for (int num: nums) {
            count[num]++;
        }
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            int cnt = count[i];
            for (int k = 0; k < cnt; k++) {
                nums[j + k] = i;
            }
            j += cnt;
        }
        
    }
}