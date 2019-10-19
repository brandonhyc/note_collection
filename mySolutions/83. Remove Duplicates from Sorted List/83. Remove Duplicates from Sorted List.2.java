/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //   0 1 2 3 
        // d-1-3-4-n
        //         c
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode cur = head;
        ListNode next = cur.next;
        
        while (cur != null) {
            while (next != null && next.val == cur.val) {
                next = next.next;
            }
            cur.next = next;
            cur = cur.next;
        }
        return dummy.next;
    }
}