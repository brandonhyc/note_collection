class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
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

        ListNode prev = start.next;
        if (prev.next == null) {
            return dummy.next;
        }
        ListNode cur = prev.next;


        for (int i = m; i < n; i++) {
            if (cur == null) {
                return null;
            }
            ListNode temp = cur.next;
            cur.next = prev;

            prev = cur;
            cur = temp;
        }

        start.next.next = cur; 
        start.next = prev;

        return dummy.next;


    }

}