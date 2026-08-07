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

        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /** Use extra memory*/

    // public ListNode reverseList(ListNode head) {

    //     ListNode reverseList = null;
    //     while(head != null) {
    //         ListNode node = new ListNode();
    //         node.val = head.val;
    //         node.next = reverseList;
    //         reverseList = node;

    //         head = head.next;
    //     }

    //     return reverseList;
        
    // }
}
