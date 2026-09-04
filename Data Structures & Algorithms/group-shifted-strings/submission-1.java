class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> sameShift = new HashMap<>();

        for (String s: strings) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < s.length(); i++) {
                char c1 = s.charAt(i-1);
                char c2 = s.charAt(i);
                sb.append((c2 - c1 + 26) % 26 + 'a');
            }

            String key = sb.toString();
            if (!sameShift.containsKey(key)) {
                sameShift.put(key, new ArrayList());
            } 
            sameShift.get(key).add(s);
        }

        for (String key: sameShift.keySet()) {
            res.add(sameShift.get(key));
        }

        return res;
    }
}
