/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        ListNode root = head;
        while (root != null) {
            stack.push(root.val);
            root = root.next;
        }

        int res = 0;
        root = head;
        int n = stack.size();
        for (int i = 0; i < n; i += 2) {
            res = Math.max(res, root.val + stack.pop());
            root = root.next;
        }

        return res;
    }
}