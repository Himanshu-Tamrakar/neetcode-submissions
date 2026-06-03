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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return dfs(root, target);
    }

    private TreeNode dfs(TreeNode x, int target) {
        if (x == null) return null;
       
        x.left = dfs(x.left, target);
        x.right = dfs(x.right, target);

        if (isLeaf(x) && x.val == target) {
            return null;
        }
        
        return x;
    }

    private boolean isLeaf(TreeNode x) {
        return x.left == null && x.right == null;
    }
}