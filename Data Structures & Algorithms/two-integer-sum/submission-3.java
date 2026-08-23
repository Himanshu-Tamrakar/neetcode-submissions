public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); 

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] {
                    map.get(diff),
                    i
                };
            } else {
                map.put(num, i);
            }
            

        }
        return new int[0];
    }

    // two pass solution
    // public int[] twoSum(int[] nums, int target) {
    //     Map<Integer, Integer> map = new HashMap<>(); 

    //     for (int i = 0; i < nums.length; i++) {
    //         map.put(nums[i], i);
    //     }

    //     for (int i = 0; i < nums.length; i++) {
    //         int diff = target - nums[i];
    //         if (map.containsKey(diff) && map.get(diff) != i) {
    //             return new int[]{i, map.get(diff)};
    //         }
    //     }

    //     return new int[0];
    // }
}