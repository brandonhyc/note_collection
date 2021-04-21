package codingPad.amz;

public class merge {
    public static class Node<T> {
        public T val;
        public Node<T> next;

        public Node(T val) {
            this(val, null);
        }

        public Node(T val, Node<T> next) {
            this.val = val;
            this.next = next;
        }
    }
    public static Node<Integer> merge(Node<Integer> l1, Node<Integer> l2) {

        Node<Integer> dummy = new Node<Integer> (-1), tail = dummy;
        while (l1 != null || l2 != null) {
            Integer v1 = l1 != null ? l1.val : Integer.MAX_VALUE;
            Integer v2 = l2 != null ? l2.val : Integer.MAX_VALUE;

            if (l1 != null && v1 <= v2) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        return dummy.next;
    }
}
