class Solution {
    public int maxArea(int[] heights) {

        int max = 0;
        int n = heights.length;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            max = Math.max(
                max,
                Math.min(heights[i], heights[j]) * (j - i)
            );

            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }

        return max;
        
    }
}
