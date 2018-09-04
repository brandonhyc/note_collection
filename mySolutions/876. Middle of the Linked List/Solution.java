/**
 * Definition for ListNode 
 * public class ListNode { 
 *  int val; 
 *  ListNode next;
 *  ListNode(int x) { 
 *      val = x; next = null; 
 *  } 
 * }
 */

public class Solution {
    /**
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) {

        // write your code here
        if (head == null) return null;

        ListNode start = head, end = head;
        int count = 0;
        while (end.next != null) {
            end = end.next;
            count++;
        }
        for (int i = 0; i < count / 2; i++) {
            start = start.next;
        }
        return start;
    }
}