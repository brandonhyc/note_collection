/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        
        dummy.next = head;
        
        head = dummy;
        
        while (head != null && head.next != null) {
            if (head.next.val != val) {
                head = head.next;
            } else {
                head.next = head.next.next;
            }
            
        }
        
        return dummy.next;
    }
}