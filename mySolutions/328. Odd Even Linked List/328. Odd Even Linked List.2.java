/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
//         1->2-3-n
//         1-2-3-n
//         2-3-n
        
//         1-3-n

        ListNode oddFirst = head;
        ListNode evenFirst = head.next;
        
        ListNode oddHead = oddFirst;
        ListNode evenHead = evenFirst; 
            
        while (oddHead != null && oddHead.next != null) {
            oddHead.next = oddHead.next.next;
            oddHead = oddHead.next;
            if (evenHead!= null && evenHead.next != null) {
                evenHead.next = evenHead.next.next;
                evenHead = evenHead.next;
            }
        }
        
        oddHead = oddFirst;
        while (oddHead.next != null) {
            oddHead = oddHead.next;
        }
        oddHead.next = evenFirst;
        
        return oddFirst;
    }
    
}