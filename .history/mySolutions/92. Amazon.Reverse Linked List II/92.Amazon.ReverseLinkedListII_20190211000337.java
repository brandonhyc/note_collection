class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null || m > n) {
            return head;
        }

        ListNode start = head;
        for (int i = 1; i < m - 1; i++) {
            if (start == null) {
                return head;
            }
            start = start.next;
        }

        ListNode cur = start.next.next;
        ListNode temp = null;
        ListNode prev = start.next;
        for (int i = m; i < n - 1; i++) {
            if (cur == null) {
                return head;
            }

            temp = cur.

        }
        

    }
}