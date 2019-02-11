class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // m = left, n = right
        if (m >= n || head == null) {
            return head;
        }

        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        ListNode start = prev, end = cur;
        ListNode temp = null;

        // reverse
        while (n > 0) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            n--;
        }

        start.next = cur;
        end.next = cur.next; 

        return head;
    }
}