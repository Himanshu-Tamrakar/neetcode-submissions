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
    private Map<TreeNode, Integer> cache;
    public int rob(TreeNode root) {
        cache = new HashMap<>();
        cache.put(null, 0);
        return dfs(root);
        
    }

    private int dfs(TreeNode x) {
        if (cache.containsKey(x)) {
            return cache.get(x);
        }
        
        int skip = dfs(x.left) + dfs(x.right);

        int include = x.val;
        if (x.left != null) {
            include += dfs(x.left.left) + dfs(x.left.right);
            
        }
        if (x.right != null) {
            include += dfs(x.right.left) + dfs(x.right.right);
        }

        int res = Math.max(skip, include);

        cache.put(x, res);

        return res;
    }

}