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
        boolean[] res = new boolean[]{ true };
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode x, boolean[] res) {
        if (x == null) {
            return 0;
        }

        int left = dfs(x.left, res);
        int right = dfs(x.right, res);

        int balanced = Math.abs(left - right);

        if (res[0]) {
            res[0] = balanced <= 1;
        }

        return 1 + Math.max(left, right);
        
    }
}
