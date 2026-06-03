class Solution {
       public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        

        int t1 = 0;
        int t2 = 1;
        int t3 = 1;
        int res;
        for (int i = 3; i <= n; i++) {
            res = t1 + t2 + t3;

            t1 = t2;
            t2 = t3;
            t3 = res;
        }

        return t3;

    }

    // public int tribonacci(int n) {
    //     if (n == 0) return 0;
    //     if (n == 1 || n == 2) return 1;
        

    //     int[] dp = new int[n + 1];
    //     dp[0] = 0;
    //     dp[1] = 1;
    //     dp[2] = 1;
    //     for (int i = 3; i < dp.length; i++) {
    //         dp[i] = dp[i - 1] + dp[i - 2] + dp[i-3];
    //     }

    //     return dp[n];

    // }


    // public int tribonacci(int n) {

    //     if (n == 0) return 0;
    //     if(n == 1 || n == 2) return 1;

    //     int[] memo = new int[n + 1];
    //     Arrays.fill(memo, -1);
    //     memo[0] = 0;
    //     memo[1] = 1;
    //     memo[2] = 1;

    //     return tribonacci(n, memo);
        
    // }

    // private int tribonacci(int n, int[] memo) {
    //     if (memo[n] != -1) return memo[n];

    //     memo[n] = tribonacci(n - 1, memo) + tribonacci(n - 2, memo) + tribonacci(n - 3, memo);

    //     return memo[n];
    // }
}