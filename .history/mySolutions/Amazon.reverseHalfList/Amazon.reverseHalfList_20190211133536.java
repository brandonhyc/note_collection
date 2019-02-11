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
    }

    ListNode reverseTheRest(ListNode head) {
        

        return 
    }

}
