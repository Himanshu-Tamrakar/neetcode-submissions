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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode x = q.poll();

            if (isSame(x, subRoot)) {
                return true;
            } else {
                if (x.left != null) q.offer(x.left);
                if (x.right != null) q.offer(x.right);
            }
        }

        return false;
    }

    private boolean isSame(TreeNode x1, TreeNode x2) {
        if (x1 == null && x2 == null) return true;

        if (x1 == null && x2 != null) return false;
        if (x1 != null && x2 == null) return false;
        if (x1.val != x2.val) return false;
        return isSame(x1.left, x2.left) && isSame(x1.right, x2.right);
    }
}
