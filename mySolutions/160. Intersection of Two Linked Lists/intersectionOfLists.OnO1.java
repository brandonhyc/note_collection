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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here

        if (headA == null || headB == null) {
            return null;
        }

        // set up two pointers,
        // redirect B when reaching tail,
        ListNode nodeA = headA, nodeB = headB;

        // for null case
        while (nodeA.next != null) {
            nodeA = nodeA.next;
        }
        while (nodeB.next != null) {
            nodeB = nodeB.next;
        }
        if (nodeA != nodeB) {
            return null;
        }

        // for intersection case
        nodeA = headA;
        nodeB = headB;

        while (nodeA != nodeB) {
            if (nodeA == nodeB) {
                break;
            }
            
            nodeA = (nodeA == null) ? headB : nodeA.next;
            nodeB = (nodeB == null) ? headA : nodeB.next;
        }
        
        return nodeA;
    }
}