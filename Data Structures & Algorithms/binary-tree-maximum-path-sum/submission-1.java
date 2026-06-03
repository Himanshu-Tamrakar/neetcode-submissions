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

        int left = dfs(x.left);
        int right = dfs(x.right);
        
        if (left < 0) {
            left = 0;
        }

        if (right < 0) {
            right = 0;
        }
        max = Math.max(max, left + right + x.val);
        return x.val + Math.max(left, right); // we always return non splitting path

    }
}
