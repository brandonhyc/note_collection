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
// lint: 288
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

        ListNode fast = head, slow = head;
        // [1,2,3,4,5,6,7,8]
        //        s     f
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}