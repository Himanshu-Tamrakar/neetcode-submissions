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
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack();

        while (curr != null || !stack.isEmpty()) {
            if (curr == null) {
                curr = stack.pop();
            }

            res.add(curr.val);
            if (curr.right != null) stack.push(curr.right);
            curr = curr.left;
        }

        return res;

        
    }
}