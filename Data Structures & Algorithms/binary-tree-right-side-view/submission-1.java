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
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode rightMost= null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode x = queue.poll();
                if (x != null) {
                    rightMost = x;
                    queue.offer(x.left);
                    queue.offer(x.right);
                }
            }
            if (rightMost != null) {
                res.add(rightMost.val);
            }
        }

        return res;
    }
}
