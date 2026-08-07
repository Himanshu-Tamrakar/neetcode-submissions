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
    public ListNode reverseList(ListNode head) {
        ListNode reverseList = null;
        while(head != null) {
            ListNode node = new ListNode();
            node.val = head.val;
            node.next = reverseList;
            reverseList = node;

            head = head.next;
        }

        return reverseList;
        
    }
}
