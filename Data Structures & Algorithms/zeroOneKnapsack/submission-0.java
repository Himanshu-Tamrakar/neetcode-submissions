class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        return dfs(profit, weight, 0, capacity);
    }

    private int dfs(List<Integer> profit, List<Integer> weight, int i, int cap) {
        if (i == profit.size()) return 0;

        int maxProfit = dfs(profit, weight, i+1, cap);
        int newCap = cap - weight.get(i);
        if (newCap >= 0) {
            int p = profit.get(i) +  dfs(profit, weight, i+1, newCap);
            maxProfit = Math.max(p, maxProfit);
        }
        return maxProfit;
    }
}
