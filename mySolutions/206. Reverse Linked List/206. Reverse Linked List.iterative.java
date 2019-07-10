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
        
        ListNode newNext = null;
        
        while (head != null) {
            ListNode next = head.next;
            head.next = newNext;
            newNext = head;
            head = next;
        }
        
        return newNext;
    }
}