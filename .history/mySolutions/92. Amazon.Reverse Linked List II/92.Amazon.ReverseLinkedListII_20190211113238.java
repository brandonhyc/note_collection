class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) {
            return null;
        }

        ListNode dummy = ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode start = head;

        for (int i = 1; i < m; i++) {
            if (start == null) {
                return null;
            }
            start = start.next;
        }

        if (start == null || start.next == null) {
            return head;
        }

        ListNode prev = start, mcurNode = prev.next;
        ListNode n2 = start;
        for (int i = m; i <= n; i++) {
            if (n2 == null) {
                return null;
            }
        }

    }

}