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
    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     return dfs(p, q);
    // }

    // private boolean dfs(TreeNode p, TreeNode q) {
    //     if (p == null && q == null) return true;
    //     if (p == null && q != null) return false;
    //     if (p != null && q == null) return false;
    //     if (p.val != q.val) return false;
        
    //     return dfs(p.left, q.left) && dfs(p.right, q.right);
    // }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(p);
        q2.offer(q);

        while (!q1.isEmpty() && !q2.isEmpty()) {

            int size = q1.size();
            for (int i = 0; i < size; i++) {
                TreeNode x1 = q1.poll();
                TreeNode x2 = q2.poll();
                
                if (x1 == null && x2 == null) continue;
                if (x1 == null && x2 != null) return false;
                if (x1 != null && x2 == null) return false;
                if (x1.val != x2.val) return false;
                
                q1.offer(x1.left);
                q1.offer(x1.right);
                q2.offer(x2.left);
                q2.offer(x2.right);
            }

            if (q1.size() != q2.size()) return false;

        }

        return true;
    }
}
