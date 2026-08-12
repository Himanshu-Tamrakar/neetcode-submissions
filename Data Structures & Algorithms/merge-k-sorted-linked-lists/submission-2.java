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
        Comparator<ListNode> byVal = (n1, n2) -> Integer.compare(n1.val, n2.val);
        PriorityQueue<ListNode> pq = new PriorityQueue<>(byVal);
        ListNode res = new ListNode();
        ListNode curr = res;
        for(ListNode list: lists) {
            pq.add(list);
        }
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.add(node.next);
            }
            curr.next = node;
            curr = curr.next;
        }

        return res.next;


    }
//     public ListNode mergeKLists(ListNode[] lists) {
//         ListNode curr = new ListNode();
//         ListNode res = curr;
//         while (true) {
//             int minIdx = -1;
//             for (int i = 0; i < lists.length; i++) {
//                 if (lists[i] != null) {
//                     if (minIdx == -1) minIdx = i;
//                     else if (lists[i].val < lists[minIdx].val) {
//                         minIdx = i;
//                     }
//                 }
//             }
//             if (minIdx == -1) break;
//             curr.next = lists[minIdx];
//             curr = curr.next;
//             lists[minIdx] = lists[minIdx].next;
//         }
//         return res.next;
//     }
}
