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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }

        if (nodes.size() - n == 0) {
            return nodes.get(0).next;
        }
        else if (n == 1) {
            nodes.get(nodes.size() - 2).next = null;
        } else {
            ListNode prev = nodes.get(nodes.size() - n - 1);
            ListNode next = nodes.get(nodes.size() - n + 1);
            prev.next = next;
            nodes.get(nodes.size() - n).next = null;
        }

        return head;
        
    }
}
