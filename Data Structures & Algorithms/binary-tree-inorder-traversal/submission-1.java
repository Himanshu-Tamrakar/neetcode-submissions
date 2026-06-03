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
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     inorder(root, res);
    //     return res;
    // }

    // private void inorder(TreeNode x, List<Integer> res) {
    //     if (x == null) return;

    //     inorder(x.left, res);
    //     res.add(x.val);
    //     inorder(x.right, res);
    // }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        // go left until possible -> pop -> add result -> move curr to right and continue untill curr is not null or stack is not empty
        while (curr != null || stack.size() > 0) {
            
            while(curr != null) {
                stack.push(curr);  
                curr = curr.left;
            }

            curr = stack.pop();
            res.add(curr.val);

            curr = curr.right;
            
        }
        
        return res;
    }
}