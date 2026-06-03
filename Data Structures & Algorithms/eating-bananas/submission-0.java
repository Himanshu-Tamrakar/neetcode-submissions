class Solution {
    // N * log(max(piles))
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = piles[0];
        for (int pile: piles) hi = Math.max(hi, pile);
        int res = 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (canFinish(piles, mid, h)) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return res;

    }

    private boolean canFinish(int[] piles, int k, int h) {
        int res = 0;
        for (int pile: piles) {
            res += Math.ceil((double) pile / k);
        }
        return res <= h;
    }    
}
