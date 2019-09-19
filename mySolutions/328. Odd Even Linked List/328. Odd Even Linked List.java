/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyEven = head.next;

        ListNode headOdd = head;
        ListNode headEven = head.next;

        while (headEven != null && headEven.next != null) {
            headOdd.next = headOdd.next.next;
            headEven.next = headEven.next.next;

            headOdd = headOdd.next;
            headEven = headEven.next;
        }
        if (headEven != null) {
            headEven.next = null;
        }
        headOdd.next = dummyEven;

        return head;
    }
}