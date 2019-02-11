class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) {
            return null;
        }

        ListNode dummy = ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode n1 = head;

        for (int i = 1; i < m; i++) {
            if (n1 == null) {
                return null;
            }
            n1 = n1.next;
        }

        if (n1 == null || n1.next == null) {
            return null;
        }
    
    }

}