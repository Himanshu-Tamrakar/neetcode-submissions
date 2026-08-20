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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return result;
        }

        q.add(root);

        while(!q.isEmpty()) {
            
            for (int i = q.size(); i > 0; i--) {
                TreeNode x = q.poll();
                if (i == 1) {
                    result.add(x.val);
                }
                
                if (x.left != null) {
                    q.offer(x.left);
                }

                if (x.right != null) {
                    q.offer(x.right);
                } 
                
            }

        }

        return result;
        
    }
}
