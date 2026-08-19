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
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        isHeightBalanced(root);
        return isBalanced;
    }

    private int isHeightBalanced(TreeNode x) {
        if (x == null) return 0;

        int leftHeight = isHeightBalanced(x.left);
        int rightHeight = isHeightBalanced(x.right);

        if (Math.abs(leftHeight - rightHeight) > 1) isBalanced = false;

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
