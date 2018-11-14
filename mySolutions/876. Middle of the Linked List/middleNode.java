/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) {
        // write your code here
        
        if (head == null) {
            return null;
        }

        int count = 1;
        ListNode node = head;

        while (node.next != null) {
            count++;
            node = node.next;
        }

        node = head;
        int mid = count % 2 == 0 ? count / 2 : count / 2 + 1;
        for (int i = 1; i < mid; i++) {
            node = node.next;
        }
        return node;
        


    }
}