class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // m = left, n = right
        if (m >= n || head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);

        dummy.next = head;
        head = dummy;

        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }

        ListNode premNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode,
                 postnNode = mNode.next;
    }
}