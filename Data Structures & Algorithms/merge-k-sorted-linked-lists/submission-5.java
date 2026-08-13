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
        if (lists == null || lists.length == 0) {
            return null;
        }
        while (lists.length > 1) {
            List<ListNode> mergedLists = new ArrayList<>();

            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1) < lists.length ? lists[i + 1] : null;
                mergedLists.add(mergeList(l1, l2));
            }

            lists = mergedLists.toArray(new ListNode[0]);
        }
        return lists[0];
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode curr = res;

        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        } 
        if (l2 != null) {
            curr.next = l2;
        }
        return res.next;
    }



    // size O(len(lists)) = k
    // time O(nlogk)
    // public ListNode mergeKLists(ListNode[] lists) {
    //     Comparator<ListNode> byVal = (n1, n2) -> Integer.compare(n1.val, n2.val);
    //     PriorityQueue<ListNode> pq = new PriorityQueue<>(byVal);
    //     ListNode res = new ListNode();
    //     ListNode curr = res;
    //     for(ListNode list: lists) {
    //         pq.add(list);
    //     }
    //     while(!pq.isEmpty()) {
    //         ListNode node = pq.poll();
    //         if (node.next != null) {
    //             pq.add(node.next);
    //         }
    //         curr.next = node;
    //         curr = curr.next;
    //     }
    //     return res.next;
    // }

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
