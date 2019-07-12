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
        
        if (head == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        boolean result = true;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode fromLeft = head;
        ListNode fromRight = null;
        
        // for case 1 bebore null
        if (fast == null) {
            fromRight = reverse(slow);
        } 
        else if (fast.next == null) {
            slow = slow.next;
            fromRight = reverse(slow);
        }
        
        
        while (fromRight != null) {
            if (fromLeft.val != fromRight.val) {
                result = false;
            }
            fromLeft = fromLeft.next;
            fromRight = fromRight.next;
            
        }
        
        return result;
    }
    
    private void printList(ListNode head) {
        while (head != null) {
            System.out.printf("%d ->", head.val);
            head = head.next;
        }
        System.out.println();
    }
    
    private ListNode reverse(ListNode head) {
        
        ListNode newNext = null;
        ListNode dummy = head;
        while (head != null) {
            ListNode next = head.next;
            head.next = newNext;
            newNext = head;
            head = next;
        }
        
        return newNext; 
    }
}