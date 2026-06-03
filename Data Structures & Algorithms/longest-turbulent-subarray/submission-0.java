class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int l = 0, r = 1;
        int res = 1;
        String prev = "";

        while (r < arr.length) {
            if (arr[r - 1] < arr[r] && !prev.equals("<")) {
                res = Math.max(res, r - l + 1);
                r++;
                prev = "<";
            } 
            else if (arr[r -1] > arr[r] && !prev.equals(">")) {
                res = Math.max(res, r - l + 1);
                r++;
                prev = ">";
            } else {
                if (arr[r - 1] == arr[r]) {
                    l = r;
                    r++;
                }
                else {
                    l = r - 1;
                }
                prev = "";
            }
        }
        return res;
    }
}