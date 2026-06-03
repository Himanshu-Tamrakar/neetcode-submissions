class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        for (List<String> list: map.values()) {
            res.add(list);
        }

        return res;

    }

 
}
