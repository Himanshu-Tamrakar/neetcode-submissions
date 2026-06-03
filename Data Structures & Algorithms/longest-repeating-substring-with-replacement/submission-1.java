class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();

            for (int j = i; j < s.length(); j++) {

                map.put(s.charAt(j), 1 + map.getOrDefault(s.charAt(j), 0));

                char maxChar;
                int max = Integer.MIN_VALUE;
                for (Map.Entry<Character, Integer>e: map.entrySet()) {
                    if (max < e.getValue()) {
                        maxChar = e.getKey();
                        max = e.getValue();
                    }
                }

                if ((j - i + 1) - max <= k) {
                    res = Math.max(res, j - i + 1);
                }

            }
        }

        return res;

    }
}
