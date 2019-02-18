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
    /*
     * @param node: a list node in the list
     * @param x: An integer
     * @return: the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // write your code here

        if (node == null) {
            return node;
        }
        ListNode head = node;
        ListNode prev = node;
        node = node.next;
        while (node != head) {
            prev = prev.next;
            node = node.next;
        }
        
    }
}