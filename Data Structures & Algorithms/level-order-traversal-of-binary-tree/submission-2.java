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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            List<Integer> levelWiseList = new ArrayList<>();
            
            for (int i = queue.size(); i > 0; i--) {
                TreeNode x = queue.poll();
                levelWiseList.add(x.val);
                if (x.left != null) {
                    queue.offer(x.left);
                }
                if (x.right != null) {
                    queue.offer(x.right);
                }
            }

            result.add(levelWiseList);

        }

        return result;
        
    }
}
