class Solution {
    public int majorityElement(int[] nums) {
        // Boyer Moore Algorithms
        int count = 0;
        int res = 0;

        for (int num: nums) {
            if (res != num) {
                if (count > 0) { 
                    count--;
                } else {
                    res = num;
                    count = 1;
                }
            } else {
                count++;
            }
            
        }

        return res;

    }
}