class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int res = 0;
        for (int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), 1 + map.getOrDefault(s.charAt(r), 0));

            
            int max = Integer.MIN_VALUE;
            for (Map.Entry<Character, Integer>e: map.entrySet()) {
                if (max < e.getValue()) {
                    max = e.getValue();
                }
            }

            if ((r - l + 1) - max <= k) {
                 res = Math.max(res, r - l + 1);
            } else {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
        }

        return res;

    }
}
