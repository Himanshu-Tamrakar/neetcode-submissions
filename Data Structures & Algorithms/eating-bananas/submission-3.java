class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = piles[0];
        for (int pile: piles) {
            if (lo > pile) lo = pile;
            if (hi < pile) hi = pile;
        }
        
        int res = hi;

        while (lo <= hi) {
            int k = lo + (hi - lo) / 2;
            int eatTime = eatTimeWith(piles, k);
            if (eatTime > h) {
                lo = k + 1;
            } else {
                res = k;
                hi = k - 1;
            }
        }

        return res;
    }

    private int eatTimeWith(int[] piles, int speed) {
        int hours = 0;
        for (int pile: piles) {
            hours += pile / speed;
            if (pile % speed != 0) hours += 1;
        }
        return hours;
    }
}
