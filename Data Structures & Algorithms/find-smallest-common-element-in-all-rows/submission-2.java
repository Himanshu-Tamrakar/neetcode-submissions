class Solution {
    
    public int smallestCommonElement(int[][] mat) {
        Map<Integer, Set<Integer>> indexWiseElems = new HashMap<>();
        for (int i = 1; i < mat.length; i++) {
            int[] vals = mat[i];
            Set<Integer> set = new HashSet<>();
            for (int val: vals) {
                set.add(val);
            }
            indexWiseElems.put(i, set);
            
        }

        for (int target: mat[0]) {
            boolean found = true;
            for (int i = 1; i < mat.length; i++) {
                if (!indexWiseElems.get(i).contains(target)) {
                    found = false;
                    break;
                }
            }

            if (found) return target;
        }

        return -1;
    }

    // mnlogm: looks good
    // public int smallestCommonElement(int[][] mat) {
    //     for (int target: mat[0]) {
    //         boolean found = true;
    //         for (int i = 1; i < mat.length; i++) {
    //             if (rank(mat[i], 0, mat[i].length - 1, target) == -1) {
    //                 found = false;
    //                 break;
    //             }
    //         }

    //         if (found) return target;
    //     }

    //     return -1;

    // }

    // private int rank(int[] arr, int lo, int hi, int target) {
        
    //     while (lo <= hi) {
    //         int mid = lo + (hi - lo) / 2;
    //         if (arr[mid] < target) lo = mid + 1;
    //         else if (arr[mid] > target) hi = mid - 1;
    //         else return mid;
    //     }

    //     return -1;
    // }
}
