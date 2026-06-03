class Solution {
    public int maxArea(int[] heights) {

        int max = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max (
                    max,
                    Math.min(heights[i], heights[j]) * (j - i)
                );
            }
        }

        return max;
        
    }
}
