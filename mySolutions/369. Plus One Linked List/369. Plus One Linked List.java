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
            return head;
        }
        
        if (helper(head) > 0) {
            ListNode node = new ListNode(1);
            node.next = head;
            return node;
        }
        
        return head;
    }
    
    private int helper(ListNode head) {
        if (head == null) {
            return 1;
        }
        
        int carry = helper(head.next);
        int value = head.val + carry;
        
        if (value > 9) {
            value = 0;
            head.val = 0;
            return 1;
        }
        
        head.val = value;
        return 0;
    }
}