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
        TreeNode x = root;
        Stack<TreeNode> stack = new Stack();

        while (!stack.isEmpty() || x != null) {
            
            if (x == null) {
                x = stack.pop();
            }

            res.add(x.val);

            if (x.right != null) stack.push(x.right);
            x = x.left;
            
        }
        return res;

        
    }
}