/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
//       n    
//       d-1-2-3-4-5-n
//         size = 5
//         size - n
            
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        
        ListNode pre = dummy;
        head = dummy.next;
        for (int i = 1; i <= size - n; i++) {
            pre = head;
            head = head.next;
        }
        pre.next = pre.next.next;
        
        return dummy.next;
    }
}