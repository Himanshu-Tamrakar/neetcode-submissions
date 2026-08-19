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

    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }

    private int[] dfs(TreeNode x) {
        if (x == null) {
            return new int[]{1, 0};
        }
        int[] left = dfs(x.left);
        int[] right = dfs(x.right);

        boolean balanced = (left[0] == 1 && right[0] == 1 && Math.abs(left[1] - right[1]) <= 1);
        int height = 1 + Math.max(left[1], right[1]);

        return new int[] { balanced ? 1 : 0, height};
    }

    // boolean isBalanced = true;
    // public boolean isBalanced(TreeNode root) {
    //     isHeightBalanced(root);
    //     return isBalanced;
    // }

    // private int isHeightBalanced(TreeNode x) {
    //     if (x == null) return 0;

    //     int leftHeight = isHeightBalanced(x.left);
    //     int rightHeight = isHeightBalanced(x.right);

    //     if (Math.abs(leftHeight - rightHeight) > 1) isBalanced = false;

    //     return 1 + Math.max(leftHeight, rightHeight);
    // }
}
