class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 0;
        int hi = 0;
        for (int weight: weights) {
            lo = Math.max(lo, weight);
            hi += weight;
        }
        int res = hi;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canFinish(weights, mid, days)) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return res;
        
    }

    private boolean canFinish(int[] weights, int capacity, int days) {
        int daysRequired = 0;
        int i = 0;        
        while (i < weights.length) {
            daysRequired++;

            int curr = 0;
            while (i < weights.length && (curr + weights[i]) <= capacity) {
                curr += weights[i];
                i++;
            }

        }

        return daysRequired <= days;
    }
}