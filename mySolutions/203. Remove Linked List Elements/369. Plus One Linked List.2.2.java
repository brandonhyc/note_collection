/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return new ListNode(1);
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode lastNotNine = dummy;
        
        while (head.next != null) {
            if (head.val != 9) {
                lastNotNine = head;
            }
            head = head.next;
        }
        
        if (head.val < 9) {
            head.val = head.val + 1;
            return dummy.next;
        }
        

        lastNotNine.val = lastNotNine.val + 1;

        head = lastNotNine.next;

        while (head != null) {
            head.val = 0;
            head = head.next;
        }


        if (lastNotNine == dummy) {
            return dummy;
        }

        return dummy.next;
       
    }
}