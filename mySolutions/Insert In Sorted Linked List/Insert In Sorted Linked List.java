/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode insert(ListNode head, int value) {
    ListNode newNode = new ListNode(value);
    if (head == null || head.value  >= value) {
      newNode.next = head;
      return newNode;
    }

    ListNode curr = head;
    ListNode prev = null;
    while (curr != null && curr.value < value) {
      prev = curr;
      curr = curr.next;
    }

    prev.next = newNode;
    newNode.next = curr;
    
    return head;
  }
}
