class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num: nums) {
            count[num] += 1;
        }
        int cnt = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[cnt++] = i;
            }
        }
     }
}