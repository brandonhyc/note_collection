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
        if (head == null || head.next == null || m == n) {
            return head;
        }

        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for (int i = 0; i < m - 1; i++) {
            head = head.next;
        }
        ListNode pre = head;
        // System.out.printf("pre: %d\n", pre.val);
        ListNode start = pre.next;
        ListNode then = start.next;
        
        
        // print(dummy.next);
        
        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
            
            // print(dummy.next);
        }
        
        return dummy.next;
        
    }
    
    private void print(ListNode node) {
        while (node != null) {
            System.out.printf("%d->", node.val);
            node = node.next;
        }
        System.out.println();
    }
}