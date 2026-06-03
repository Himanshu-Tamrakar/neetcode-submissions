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
    // public int goodNodes(TreeNode root) {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    //     pq.offer(Integer.MIN_VALUE);
    //     return dfs(root, pq);
    // }

    // private int dfs(TreeNode x, PriorityQueue<Integer> pq) {
    //     if (x == null) {
    //         return 0;
    //     }

    //     int res = 0;
    //     if (pq.peek() <= x.val) {
    //         res++;
    //         pq.offer(x.val);
    //     }   

    //     int left = dfs(x.left, pq);
    //     int right = dfs(x.right, pq);
        
    //     if (x.val == pq.peek()) pq.poll();
        
    //     return res + left + right;

    // } 

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode x, int maxVal) {
        if (x == null) {
            return 0;
        }

        int res = (x.val >= maxVal) ? 1 : 0;
        maxVal = Math.max(maxVal, x.val);

        res += dfs(x.left, maxVal);
        res += dfs(x.right, maxVal);
        
        return res;

    } 
}
