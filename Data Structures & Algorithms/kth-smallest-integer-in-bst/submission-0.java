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
    public int kthSmallest(TreeNode root, int k) {
        return select(root, k).val;
    }

    private TreeNode select(TreeNode x, int rank) {
        if (x == null) {
            return null;
        }

        int leftSize = 1 + sizeOfTree(x.left);
        
        if (leftSize > rank) return select(x.left, rank);
        else if (leftSize < rank) return select(x.right, rank - leftSize);
        else return x;
    }

    private int sizeOfTree(TreeNode x) {
        if (x == null) return 0;
        return 1 + sizeOfTree(x.left) + sizeOfTree(x.right);
    }
}
