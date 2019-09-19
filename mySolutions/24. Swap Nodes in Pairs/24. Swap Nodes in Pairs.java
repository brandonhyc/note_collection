/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode third = head.next.next;
        ListNode second = head.next;
        head.next = swapPairs(third);
        second.next = head;

        return second;
    }
}