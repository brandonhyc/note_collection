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
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here

        if (head == null) {
            return false;
        }

        Set<ListNode> set = new HashSet<>();
        ListNode node = head;

        while (node.next != null) {
            if (set.add(node)) {
                node = node.next;
                continue;
            }
            return true;
        }

        return false;

    }
}