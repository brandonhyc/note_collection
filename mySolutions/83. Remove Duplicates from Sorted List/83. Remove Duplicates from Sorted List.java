/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        if (head == null) {
            return head;
        }
        
        Set<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        while (head != null) {
            set.add(head.val);
            
            while (head.next != null && set.contains(head.next.val)) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        
        return dummy.next;
    }
}