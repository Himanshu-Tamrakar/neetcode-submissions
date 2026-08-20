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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    private boolean dfs(TreeNode x, int currSum, int targetSum) {
        if (x == null) return false;

        currSum += x.val;
        if (x.left == null && x.right == null) {
            return currSum == targetSum;
        }
        
        return dfs(x.left, currSum, targetSum) || dfs(x.right, currSum, targetSum);
    }
}