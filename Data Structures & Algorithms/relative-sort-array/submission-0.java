class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> count = new TreeMap<>();
        
        for (int num : arr1) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        int[] result = new int[arr1.length];
        int index = 0;
        
        
        for (int num : arr2) {
            if (count.containsKey(num)) {
                int freq = count.get(num);
                for (int i = 0; i < freq; i++) {
                    result[index++] = num;
                }
                count.remove(num);
            }
        }
        
        
        for (int key : count.keySet()) {
            int freq = count.get(key);
            for (int i = 0; i < freq; i++) {
                result[index++] = key;
            }
        }
        
        return result;
    }
}
