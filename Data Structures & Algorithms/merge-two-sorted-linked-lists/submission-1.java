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
    // O(N) & O(N) space
    // public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    //     if (list1 == null) {
    //         return list2;
    //     }     
    //     if (list2 == null) {
    //         return list1;
    //     }

    //     if (list1.val <= list2.val) {
    //         list1.next = mergeTwoLists(list1.next, list2);
    //         return list1;
    //     } else {
    //         list2.next = mergeTwoLists(list1, list2.next);
    //         return list2;
    //     }
    // }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null;
        ListNode curr = null;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (curr == null) {
                    curr = list1;
                    result = curr;
                } else {
                    curr.next = list1;
                    curr  = curr.next;
                }
                
                list1 = list1.next;
             } else {
                if (curr == null) {
                    curr = list2;
                    result = curr;
                } else {
                    curr.next = list2;
                    curr  = curr.next;
                }
                
                list2 = list2.next;
             }
             
        }

        while (list1 != null) {
            if (curr == null) {
                curr = list1;
                result = curr;
            } else {
                curr.next = list1;
                curr = curr.next;
            }
            list1 = list1.next;
        }

        while (list2 != null) {
            if (curr == null) {
                curr = list2;
                result = curr;
            } else {
                curr.next = list2;
                curr = curr.next;
            }
            list2 = list2.next;
        }

        return result;
       
    }

   
}