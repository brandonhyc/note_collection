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
//         d-1-5-n 3
//               c
            
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        head = dummy;
        
        while (head != null) {
            ListNode next = head.next;
            
            while (next != null && next.val == val) {
                next = next.next;
            }
            head.next = next;
            head = head.next;
        }
        
        
        return dummy.next;
        
    }
}