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
        
        return reverse(null, head);
    }
    
    private ListNode reverse(ListNode prev, ListNode head) {
        if (head == null) {
            return prev;
        }
        
        ListNode save = head.next;
        head.next = prev;
        
        return reverse(head, save);
    }
}