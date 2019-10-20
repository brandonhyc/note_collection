/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        int carry = 0;
        while (l1 != null || l2 != null) {
            
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            
            int sum = num1 + num2 + carry;
            
            if (sum > 9) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            
            cur.next = new ListNode(sum);
            
            cur = cur.next;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        
        return dummy.next;
        
            
    }
}