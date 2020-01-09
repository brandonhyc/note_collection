/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       
//         1-2-3
//         1-3-4
        
//         d-1-1-2-3-3-4
//                   p l
        
//         1-3-4
//             r
            
//         d-1-1-2-2-3
//                     l
//                 4
//                 r
        
//      p-1-1-2-4
//          l
//           3-4
//           r
           
        
        
            
        ListNode dummy = new ListNode(0);
        
        dummy.next = l1;
        ListNode pre = dummy;
            
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                pre.next = l2;
                l2 = l2.next;
                pre.next.next = l1;
                pre = pre.next;
            } else {
                pre = l1;
                l1 = l1.next;
            }
        }
        
        if (l2 != null && l1 == null) {
            pre.next = l2;
        }
        else if (l1 != null && l2 == null) {
            return dummy.next;
        }
            
        return dummy.next;
    }
}