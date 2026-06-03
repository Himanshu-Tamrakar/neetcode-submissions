class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, 1 + map.getOrDefault(num, 0));
        }

        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            int key = e.getKey();
            int val = e.getValue();
            if (val > (nums.length / 3)) res.add(key);
        }

        return res;
        
    }
}