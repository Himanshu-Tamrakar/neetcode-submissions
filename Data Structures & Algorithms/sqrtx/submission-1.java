class Solution {
    public int mySqrt(int x) {
        int lo = 0;
        int hi = x;
        int res = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if ((long) mid * mid > x) hi = mid - 1;
            else if ((long) mid * mid < x) {
                lo = mid + 1;
                res = mid;
            } else {
                return mid;
            }
        }
        return res;
    }
}