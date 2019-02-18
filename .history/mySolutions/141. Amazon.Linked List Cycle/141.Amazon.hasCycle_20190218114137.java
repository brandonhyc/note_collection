/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head.next;
        ListNode faster = head.next.next;

        while (slow != faster) {
            slow = slow.next;
            faster = faster.next.next;
            if (slow == null) {
                return false;
            }
            if (faster == null) {
                return false;
            }
        }

        return true;
        
    }
}