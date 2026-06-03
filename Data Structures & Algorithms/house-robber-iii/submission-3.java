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

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode x) {
        if (x == null) {
            return new int[]{0, 0};
        }

        int[] leftPair = dfs(x.left);
        int[] rightPair = dfs(x.right);

        int withRoot = x.val + leftPair[1] + rightPair[1];
        int withoutRoot = Math.max(leftPair[0], leftPair[1]) + Math.max(rightPair[0], rightPair[1]);

        return new int[] {withRoot, withoutRoot};
    }
    // private Map<TreeNode, Integer> cache;
    // public int rob(TreeNode root) {
    //     cache = new HashMap<>();
    //     cache.put(null, 0);
    //     return dfs(root);
        
    // }

    // private int dfs(TreeNode x) {
    //     if (cache.containsKey(x)) {
    //         return cache.get(x);
    //     }
        
    //     int skip = dfs(x.left) + dfs(x.right);

    //     int include = x.val;
    //     if (x.left != null) {
    //         include += dfs(x.left.left) + dfs(x.left.right);
            
    //     }
    //     if (x.right != null) {
    //         include += dfs(x.right.left) + dfs(x.right.right);
    //     }

    //     int res = Math.max(skip, include);

    //     cache.put(x, res);

    //     return res;
    // }

}