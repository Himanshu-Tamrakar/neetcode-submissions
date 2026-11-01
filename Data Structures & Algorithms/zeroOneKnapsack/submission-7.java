class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int N = profit.size();
        int M = capacity + 1;
        int[][] cache = new int[N][M];
        for (int i = 0; i < N; i++) {
           Arrays.fill(cache[i], -1);   // fills all M+1 columns
        }
        return maxHelper(0, capacity, profit, weight, cache);
    }

    private int maxHelper(int i, int capacity, List<Integer> profits, List<Integer> weights, int[][] cache) {
        if (i == profits.size()) {
            return 0;
        }

        if (cache[i][capacity] != -1) {
            return cache[i][capacity];
        }

        int maxProfit = maxHelper(i + 1, capacity, profits, weights, cache);

        int newCap = capacity - weights.get(i);
        if (newCap >= 0) {
            int p = profits.get(i) + maxHelper(i + 1, newCap, profits, weights, cache);

            maxProfit = Math.max(maxProfit, p);
        }
        cache[i][capacity] = maxProfit;

        return cache[i][capacity];
    }
}
