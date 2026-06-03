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
    // O(n) time and O(n) space
    // public void reorderList(ListNode head) {
    //     List<ListNode> nodes = new ArrayList<>();
    //     ListNode curr = head;
    //     while (curr != null) {
    //         nodes.add(curr);
    //         curr = curr.next;
    //     }
        
    //     int i = 0;
    //     int j = nodes.size() - 1;

    //     while (i < j) {
    //         nodes.get(i).next = nodes.get(j);
    //         i++;
    //         if (i >= j) break;
    //         nodes.get(j).next = nodes.get(i);
    //         j--;
    //     }

    //     nodes.get(i).next = null;
    // }

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow.next;
        ListNode prev = slow.next = null;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        
        ListNode first = head;
        ListNode second = prev;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }

    }
}
