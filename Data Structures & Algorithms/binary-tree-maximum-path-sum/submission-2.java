/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode x) {
        if (x == null) {
            return 0;
        }

        int leftMax = dfs(x.left);
        int rightMax = dfs(x.right);
        
        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);

        max = Math.max(max, leftMax + rightMax + x.val);
        return x.val + Math.max(leftMax, rightMax); // we always return not splitting path

    }
}
