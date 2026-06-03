class Solution {
    int sum = 0;
    public int lastStoneWeightII(int[] stones) {
        
        for (int stone: stones) sum += stone;

        int target = (int) Math.ceil(sum / 2.0);
        int[][] memo = new int[stones.length][target + 1];
        for (int[] row: memo) Arrays.fill(row, -1);
        int nearest = dfs(0, stones, memo, 0, target);
        

        return Math.abs(nearest - (sum - nearest));
    }

    private int dfs(int i, int[] stones, int[][] memo, int total, int target) {
        if (i == stones.length) {
            return total;
        }

        if (memo[i][total] != -1) return memo[i][total];

        int max = dfs(i + 1, stones, memo, total, target);
        int newTotal = total + stones[i];
        if (newTotal <= target) {
            int p = dfs(i + 1, stones, memo, newTotal, target);
            max = Math.max(max, p);
        }
        memo[i][total] = max;
        return memo[i][total];
    }
}