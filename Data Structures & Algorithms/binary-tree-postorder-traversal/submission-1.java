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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        Stack<Boolean> visit = new Stack();
        stack.push(root);
        visit.push(false);

        while (!stack.isEmpty()) {
            TreeNode x = stack.pop();
            boolean visited = visit.pop();
            if (x != null) {
                if (visited) {
                    res.add(x.val);
                } else {
                    stack.push(x);
                    visit.push(true);
                    stack.push(x.right);
                    visit.push(false);
                    stack.push(x.left);
                    visit.push(false);
                }
            }
        }

        return res;
    }


}