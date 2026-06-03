class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        return dfs(0, profit, weight, capacity);
    }

    private int dfs(int i, List<Integer> profit, List<Integer> weight, int cap) {
        if (i == profit.size()) {
            return 0;
        }

        int maxProfit = dfs(i + 1, profit, weight, cap);
        int newCap = cap - weight.get(i);
        if (newCap >= 0) {
            int with = profit.get(i) + dfs(i, profit, weight, newCap);
            maxProfit = Math.max(maxProfit, with);
        }
        return maxProfit;
    }
}
