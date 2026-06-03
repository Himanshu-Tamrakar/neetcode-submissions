class TimeMap {
    private Map<String, List<String[]>> table;

    public TimeMap() {
        table = new HashMap<>();
    }
    // <"key1": [["value1", 10]]
    public void set(String key, String value, int timestamp) {
        List<String[]> values =  table.computeIfAbsent(key, k -> new ArrayList<>());
        String[] entry = new String[] { value, timestamp + "" };
        values.add(entry);

        if (!table.containsKey(key)) table.put(key, values);
    }
    
    public String get(String key, int timestamp) {
        List<String[]> values =  table.getOrDefault(key, null);
        if (values == null) return "";

        int lo = 0;
        int hi = values.size() - 1;
        String res = "";
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            String[] val = values.get(mid);

            if (Integer.parseInt(val[1]) <= timestamp) {
                res = val[0];
                lo = mid + 1;
            } else if (Integer.parseInt(val[1]) > timestamp) {
                hi = mid - 1;
            }
        }

        return res;
    }
}
