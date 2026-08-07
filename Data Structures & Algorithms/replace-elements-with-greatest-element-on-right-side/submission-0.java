class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] gretest_elem = new int[n];
        gretest_elem[n-1] = arr[n-1];

        for (int i = n-2; i >= 0; i--) {
            gretest_elem[i] = Math.max(gretest_elem[i+1], arr[i+1]);
        }
        
        gretest_elem[n-1] = -1;

        return gretest_elem;
    }
}