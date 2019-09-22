/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode dummy = new ListNode(0);
        
        dummy.next = head;
        
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse the half
        ListNode pre = slow; // before half
        ListNode start = pre.next;
        ListNode then = start.next;
        
        while (then != null) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        
        ListNode left = dummy.next;
        ListNode right = slow.next;
        
        while (right != null) {
            if (left.val != right.val) {
                return false;    
            }
            
            left = left.next;
            right = right.next;
        }
        
        return true;
    }
}