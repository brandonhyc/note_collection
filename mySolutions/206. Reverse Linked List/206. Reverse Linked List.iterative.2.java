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
        if (head == null || head.next == null) {
            return head;
        }
        
//         1 -> 2 -> null
//         prev cur  save
// null <- 1    2
//        prev  cur
//         1  <- 2  x null
//        prev  cur   save
//         1   <- 2   null
//               prev cur
        
        ListNode prev = head;
        ListNode cur = head.next;
        prev.next = null;
        
        while (cur != null) {
            ListNode save = cur.next;
            cur.next = prev;
            prev = cur;
            cur = save;
        }
        
        return prev;
    }
}