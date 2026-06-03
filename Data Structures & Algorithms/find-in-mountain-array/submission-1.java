/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int lo = 0; 
        int hi = mountainArr.length() - 1;
        int peak = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int prev = mountainArr.get(mid - 1);
            int curr = mountainArr.get(mid);
            int next = mountainArr.get(mid + 1);

            if (prev <  curr && curr > next) {
                peak = mid;
                break;
            } else if (prev < curr && curr < next) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(peak);

        lo = 0;
        hi = peak;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int curr = mountainArr.get(mid);
            if (curr < target) {
                lo = mid + 1;
            } else if (curr > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        lo = peak;
        hi = mountainArr.length() - 1;
         while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int curr = mountainArr.get(mid);
            if (curr < target) {
                hi = mid - 1;
            } else if (curr > target) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;

    }
}