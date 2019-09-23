/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        
        if (head == null || head.next == null) {
            return;
        } 
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode pre = slow;
        ListNode start = pre.next;
        ListNode then = start.next;
        
        while (then != null) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        
        ListNode curr1 = dummy.next;
        ListNode curr2 = slow.next;
        slow.next = null;
        
        while (curr1 != null && curr2 != null) {
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;
            
            curr2.next = next1;
            curr1.next = curr2;
            
            curr1 = next1;
            curr2 = next2;
        }
        
        return;
    }
}