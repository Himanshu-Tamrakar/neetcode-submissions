class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i >= k) {
                currSum -= arr[i - k];
            }
            currSum += arr[i];
            if (i >= k-1 && currSum / k >= threshold) {
                System.out.println("i: " + i + ": sum: " + currSum);
                res++;
            }
        }
        return res;
    }
}