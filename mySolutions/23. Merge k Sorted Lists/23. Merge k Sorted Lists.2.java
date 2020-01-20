/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        PriorityQueue<ListNode> minheap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minheap.offer(lists[i]);
            }
        }
        
        while (minheap.size() != 0) {
            ListNode node = minheap.poll();
            head.next = node;
            head = head.next;
            
            if (node.next != null) {
                minheap.offer(node.next);
            }
        }
        
        return dummy.next;
    }
}