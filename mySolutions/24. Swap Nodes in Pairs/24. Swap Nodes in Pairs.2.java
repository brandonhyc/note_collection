/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
//     p->1->2->3->4->null
//        c  n
//     p->1->3 2->1 3->4->null
//     p->2->1->3->4->null
//              c  n
        
    
//     p->2->1->3->null
//              c  n  n == null
//     p->2->1->null
//              c   c == null || c.next == null break
        
    
    
//     p-1-2-3-null
//       c n
//     p-1-3 2-1 3-null
        
//       2-1-3-4-null
//         p c n
    public ListNode swapPairs(ListNode head) {
        
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next = cur.next;
        
        while (cur != null && next != null) {
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            pre = cur;
            cur = cur.next;
            if (cur == null || cur.next == null) {
                break;
            }
            next = cur.next;
        }
        
        
        
        return dummy.next;
    }
}

  
  0. understand very well
  1. general idea -> talk about it 
  2. ask if that's the solution you want
  3. optimize -> talk about it (write it down in your words if too complex)
  
  4. write your code
  5. try the normal cases
  6. try the edge case