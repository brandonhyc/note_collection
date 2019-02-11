public class Solution {
    public ListNode reverseList(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        reverseTheRest(slow);
        return head;
    }

    private void reverseTheRest(ListNode head) {
        // By good practice, set a dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        if (head.next = null) {
            return;
        }
        ListNode prev = head;
        ListNode cur = head.next;

        while (head != null) {
            ListNode temp = cur.next;
            cur.next = prev;

            prev = cur;
            cur = temp;
        }
        return;
    }

}
