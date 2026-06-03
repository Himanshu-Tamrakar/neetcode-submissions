class Solution {
    int sum = 0;
    public int lastStoneWeightII(int[] stones) {
        
        for (int stone: stones) sum += stone;

        int target = (int) Math.ceil(sum / 2.0);
        int nearest = dfs(0, stones, 0, target);
        System.out.println(sum + ", " + target);
        System.out.println(nearest);

        return Math.abs(nearest - (sum - nearest));
    }

    private int dfs(int i, int[] stones, int total, int target) {
        if (i == stones.length) {
            return total;
        }

        int max = dfs(i + 1, stones, total, target);
        int newTotal = total + stones[i];
        if (newTotal <= target) {
            int p = dfs(i + 1, stones, newTotal, target);
            max = Math.max(max, p);
        }
        return max;
    }
}