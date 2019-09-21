/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode dummyA = new ListNode(0);
        dummyA.next = headA;
        ListNode dummyB = new ListNode(0);
        dummyB.next = headB;
        
        
        int lenA = 0;
        while (headA != null) {
            headA = headA.next;
            lenA++;
        }
        
        int lenB = 0;
        while (headB != null) {
            headB = headB.next;
            lenB++;
        }
        
        int diff = Math.abs(lenA - lenB);
        headA = dummyA.next;
        headB = dummyB.next;
        
        for (int i = 0; i < diff; i++) {
            if (lenA > lenB) {
                headA = headA.next;
            } else {
                headB = headB.next;
            }
        }
        
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}