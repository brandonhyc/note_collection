/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode beforeNine = dummy;
        ListNode node = dummy;
        
        while (node.next != null) {
            if (node.val != 9) {
                beforeNine = node;
            }
            node = node.next;
        }
        
        if (node.val != 9) {
            node.val = node.val + 1;
            return dummy.next;
        }
        beforeNine.val = beforeNine.val + 1;
        node = beforeNine.next;
        while (node != null) {
            node.val = 0;
            node = node.next;
        }
        
        return (dummy.val == 0) ? head : dummy;
    }
}