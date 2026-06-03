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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode mergeList = new ListNode(-1001);

        for (int  i = 0; i < lists.length; i++) {
            ListNode l1 = mergeList;
            ListNode l2 = lists[i];
            ListNode res = new ListNode(-1);
            ListNode dummy = res;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    res.next = l1;
                    l1 = l1.next;
                } else {
                    res.next = l2;
                    l2 = l2.next;
                }
                res = res.next;
            }

            while (l1 != null) {
                res.next = l1;
                res = res.next;
                l1 = l1.next;
            }

            while (l2 != null) {
                res.next = l2;
                res = res.next;
                l2 = l2.next;
            }

            mergeList = dummy.next;
        }

        return mergeList.next;

    }
}
