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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode x = root;

        while (x != null) {
            // one of them matched
            if (x.val == p.val || x.val == q.val) {
                return x;
            } 
            // both go right
            else if (p.val > x.val && q.val > x.val) {
                x = x.right;
            }
            // both go left
            else if (p.val < x.val && q.val < x.val) {
                x = x.left;
            }
            // split occured 
            else {
                return x;
            }
        }
        return null;
    }
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     if (root == null) return null;

    //     if (root.val == p.val || root.val == q.val) {
    //         return root;
    //     }
    //     // both go right
    //     else if (p.val > root.val && q.val > root.val) {
    //         return lowestCommonAncestor(root.right, p, q);
    //     } 
    //     // both go left
    //     else if (p.val < root.val && q.val < root.val) {
    //         return lowestCommonAncestor(root.left, p, q);
    //     }
    //     // split one is less and other if greater than of root
    //     else {
    //         return root;
    //     }
    // }
}
