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
                newNode.next = new ListNode(l1Node.val);
                l1Node = l1Node.next;
            } else {
                newNode.next = new ListNode(l2Node.val);
                l2Node = l2Node.next;
            }
            newNode = newNode.next;
        }

        while (l1Node != null) {
            newNode.next = new ListNode(l1Node.val);
            l1Node = l1Node.next;
        }

        while (l2Node != null) {
            newNode.next = new ListNode(l2Node.val);
            l2Node = l2Node.next;
        }

        return 
        
    }
}