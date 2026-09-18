class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // left max value till i
        for (int i = 1; i < n; i++) {
            int currLeftMax = leftMax[i - 1];
            int prevHeight = height[i - 1];
            leftMax[i] = Math.max(prevHeight, currLeftMax);
        }

        // right max value till i
        for (int i = n - 2; i >= 0; i--) {
            int currRightMax = rightMax[i + 1];
            int nextHeight = height[i + 1];
            rightMax[i] = Math.max(currRightMax, nextHeight);
        }

        int res = 0;


        for (int i = 0; i < n; i++) {
            // min from left and right max should greater than current height
            if (Math.min(leftMax[i], rightMax[i]) > height[i]) {
                res += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            
        }

        return res;
    }
}
