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

        ListNode prev = null;
        ListNode cur = start.next;


        for (int i = m; i <= n; i++) {
            if (cur == null) {
                return null;
            }
            prev = cur;
            cur = cur.next;
            cur.next = prev;
        }



        return dummy.next;


    }

}