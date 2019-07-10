/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        return helper(head, null);
    }
    
    private ListNode helper(ListNode head, ListNode prev) {
        
        if (head == null) {
            return prev;
        }
            
        ListNode next = head.next;
        head.next = prev;
        
        return helper(next, head); 

    }
}