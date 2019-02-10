/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        ListNode l1Node = l1;
        ListNode l2Node = l2;
        while (l1Node != null && l2Node != null) {
            if (l1Node.val <= l2Node.val) { 
                node.next = new ListNode(l1Node.val); //3
                l1Node = l1Node.next; // l1Node = null
            } else {
                node.next = new ListNode(l2Node.val);
                l2Node = l2Node.next;
            }
            node = node.next; // node = 3
        }

        while (l1Node != null) {
            node.next = new ListNode(l1Node.val);
            l1Node = l1Node.next;
        }

        while (l2Node != null) {
            System.out.println(l2Node.val);
            node.next = new ListNode(l2Node.val);
            l2Node = l2Node.next;
        }

        return dummy.next;
    }
}