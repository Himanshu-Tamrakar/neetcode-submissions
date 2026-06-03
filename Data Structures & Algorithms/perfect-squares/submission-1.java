class Solution {
    public int numSquares(int n) {

        List<Integer> perfectSquare = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int power = i * i;
            if (power <= n) perfectSquare.add(power);
        }


        Integer[] memo = new Integer[n + 1];

        return dfs(perfectSquare, n, memo);
    }

    private int dfs(List<Integer> nums, int target, Integer[] memo) {
        if (target == 0) return 0;
        if (memo[target] != null) return memo[target];
        
        int res = (int) 1e9;
        for (int i = 0; i < nums.size(); i++) {
            if (target - nums.get(i) >= 0) {
                res = Math.min(
                    res, 
                    1 + dfs(nums, target - nums.get(i), memo)
                    );
            }
        }
        System.out.println(res);
        memo[target] = res;

        return memo[target];
    }
}