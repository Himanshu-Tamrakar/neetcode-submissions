class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int[][] cache = new int[profit.size()][capacity+1];
        for (int i = 0; i < profit.size(); i++) {
            for (int j = 0; j <= capacity; j++) {
                cache[i][j] = -1;
            }
        }
        return dfs(profit, weight, cache, 0, capacity);
    }

    private int dfs(List<Integer> profit, List<Integer> weight, int[][] cache, int i, int cap) {
        if (i == profit.size()) return 0;
        if (cache[i][cap] != -1) return cache[i][cap];

        int maxProfit = dfs(profit, weight, cache, i+1, cap);
        int newCap = cap - weight.get(i);
        if (newCap >= 0) {
            int p = profit.get(i) +  dfs(profit, weight, cache, i+1, newCap);
            maxProfit = Math.max(p, maxProfit);
        }
        cache[i][cap] = maxProfit;
        return maxProfit;
    }
}
