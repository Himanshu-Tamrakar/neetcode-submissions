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
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     List<ListNode> nodes = new ArrayList<>();
    //     ListNode curr = head;
    //     while (curr != null) {
    //         nodes.add(curr);
    //         curr = curr.next;
    //     }

    //     if (nodes.size() - n == 0) {
    //         return nodes.get(0).next;
    //     }
    //     else if (n == 1) {
    //         nodes.get(nodes.size() - 2).next = null;
    //     } else {
    //         ListNode prev = nodes.get(nodes.size() - n - 1);
    //         ListNode next = nodes.get(nodes.size() - n + 1);
    //         prev.next = next;
    //         nodes.get(nodes.size() - n).next = null;
    //     }

    //     return head;
        
    // }

    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     List<ListNode> nodes = new ArrayList<>();
    //     ListNode curr = head;
    //     while (curr != null) {
    //         nodes.add(curr);
    //         curr = curr.next;
    //     }

    //     int removeIndex = nodes.size() - n;
    //     if (removeIndex == 0) {
    //         return head.next;
    //     }

    //     nodes.get(removeIndex - 1).next = nodes.get(removeIndex).next;
    //     return head;
        
    // }

     public ListNode removeNthFromEnd(ListNode head, int n) {
        int N = 0;
        ListNode curr = head;
        while (curr != null) {
            N++;
            curr = curr.next;
        }

        int removeIndex = N - n;
        if (removeIndex == 0) {
            return head.next;
        }
        curr = head;
        for (int i = 0; i < N - 1; i++) {
            if ((i + 1) == removeIndex) {
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
        }
        
        return head;
        
    }
}
