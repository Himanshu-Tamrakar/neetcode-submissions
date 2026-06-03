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
class BSTIterator {
    TreeNode x;
    Stack<TreeNode> stack;
    List<Integer> res;
    public BSTIterator(TreeNode root) {
        res = new ArrayList();
        inorder(root, res);

    }

    private void inorder(TreeNode x, List<Integer> res) {
        if (x == null) return;
        inorder(x.left, res);
        res.add(x.val);
        inorder(x.right, res);
    }
    
    public int next() {
        int val = res.get(0);
        res.remove(0);
        return val;
    }
    
    public boolean hasNext() {
        if (res.size() == 0) return false;
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */