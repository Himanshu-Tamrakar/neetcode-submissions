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
    public List<Integer> preorderTraversal(TreeNode root) {
       List<Integer> res = new ArrayList();
       pre(root, res);
        return res;
        
    }

    private void pre(TreeNode x, List<Integer> res) {
        if (x == null ) return;

        res.add(x.val);
        pre(x.left, res);
        pre(x.right, res);
    }
}