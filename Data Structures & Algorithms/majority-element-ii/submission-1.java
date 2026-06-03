class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, 1 + map.getOrDefault(num, 0));

            if (map.size() <= 2) continue;

            Map<Integer, Integer> mapNew = new HashMap<>();
            for (Map.Entry<Integer, Integer> e: map.entrySet()) {
                int k = e.getKey();
                int v = e.getValue();
                if (v > 1) {
                    mapNew.put(k, v - 1);
                }
            }
            map = mapNew;
        }



        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            int key = e.getKey();
            int val = e.getValue();
            int cnt = 0;
            for (int num: nums) {
                if (num == key) cnt++;
            }
            if (cnt > nums.length / 3) res.add(key);
        }

        return res;
        
    }
}