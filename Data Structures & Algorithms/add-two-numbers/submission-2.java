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
    // public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    //     ListNode result = new ListNode(0);
    //     ListNode dummy = result;
    //     int carry = 0;
    //     while (l1 != null && l2 != null) {
    //         int total = l1.val + l2.val + carry;
    //         carry = total / 10;
    //         total = total % 10;
    //         result.next = new ListNode(total);
    //         result = result.next;
    //         l1 = l1.next;
    //         l2 = l2.next;
    //     }

    //     while (l1 != null) {
    //         int total = l1.val + carry;
    //         carry = total / 10;
    //         total = total % 10;

    //         result.next = new ListNode(total);
    //         result = result.next;
    //         l1 = l1.next;
    //     }

    //     while (l2 != null) {
    //         int total = l2.val + carry;
    //         carry = total / 10;
    //         total = total % 10;

    //         result.next = new ListNode(total);
    //         result = result.next;
    //         l2 = l2.next;
    //     }
    
    //     if (carry > 0) {
    //         result.next = new ListNode(carry);
    //     }

    //     return dummy.next;
        
    // }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int val = v1 + v2 + carry;

            carry = val / 10;
            val = val % 10;
            curr.next = new ListNode(val);
            curr = curr.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return dummy.next;
    }
}
