class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length < 2) return arr.length;
        int res = 1;
        int L = 0;

        for (int R = 1; R < arr.length - 1; R++) {
            if (arr[R] > arr[R - 1] && arr[R] > arr[R + 1]) {
                res = Math.max(res, R - L + 2);
                
            } else if (arr[R] < arr[R - 1] && arr[R] < arr[R + 1]) {
                res = Math.max(res, R - L + 2);
                
            } else {
                L = R;
            }
        }

        if (arr[arr.length - 1] != arr[arr.length - 2]) {
            res = Math.max(res, 2);
        }

        return res;
    }
}