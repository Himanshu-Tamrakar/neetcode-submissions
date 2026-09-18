class Solution {
    // Two pointer or sliding window
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int max = 0;

        while (i < j) {
            int width = j - i;
            int height = Math.min(heights[i], heights[j]);
            max = Math.max(max, width * height);
            if (heights[i] < heights[j]) {
                i++; 
            } else {
                j--;
            }
        }

        return max;
    }
}
