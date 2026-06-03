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
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }

     private TreeNode delete(TreeNode node, int key) {
        if (node == null) return null;

        int cmp = key - node.val;
        if      (cmp < 0) node.left  = delete(node.left,  key);
        else if (cmp > 0) node.right = delete(node.right, key);
        else {
            if (node.right == null) return node.left;
            if (node.left  == null) return node.right;
            TreeNode temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        
        return node;
    }

    private TreeNode min(TreeNode node) {
        if (node.left == null) return node;
        else                   return min(node.left);
    }

    
    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        
        return node;
    }
}