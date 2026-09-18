class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (count.get(num) == 1) {
                arr.add(num);
            }
        }

        int i = 0;
        for (int num: arr) {
            nums[i++] = num;
            count.put(num, count.get(num) - 1);
            if (count.get(num) >= 1) {
                nums[i++] = num;
                count.put(num, count.get(num) - 1);
            }
        }
        return i;
    }
}