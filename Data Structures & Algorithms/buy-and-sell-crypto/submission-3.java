class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int res = 0;
        while (r < prices.length) {
            if (prices[l] > prices[r]) {
                l = r;
            } else {
                System.out.println(l + " " + r);
                res = Math.max(res, prices[r] - prices[l]);
            }

            r++;
        }

        return res;
    }
}
