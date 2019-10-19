/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
//         1-[2-3-4]-5-n 1-[4-3-2]-5-n
          
//         1. 1-[3-2]-4-5-n
        
//         2. 1-4-3-2-5-n
            
//         p c n  
//         1-2-3-4-5
//         1-2-4-1 3-2 
//         1-[3-2]-4-5-n
//         p    c  n     
//         n is actually ListNode next in the graph
//         2. 
//         1-3-2-4-1-n
//         1-3-2--n 4-3-2-5-n         
        
//         1-4-3-2-5-n
//           n   c    if n == next.val, break;
//         5-4-3-2-1-n
//                 c n        
    
//         2.
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        head = dummy;
        // to get node before m
        for (int i = 1; i <= m - 1; i++) {
            head = head.next;
        }
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = head;
        ListNode cur = head.next;
        ListNode next = head.next.next;
        
        for (int i = 1; i <= n - m; i++) {
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = cur.next;
        }
        
        return dummy.next;
    }
}