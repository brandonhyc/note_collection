/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode dummyA = headA;
        ListNode dummyB = headB;

        while (headA != headB) {
            if (headA == null && headB == null) {
                return null;
            }
            headA = headA != null ? headA.next : dummyB;
            headB = headB != null ? headB.next : dummyA;

        }
        return headA;
    }

}