// 重点, 考察到 1.双向链的应用 2. 多线程

public class LRUCache {
    /*
    * @param capacity: An integer
    */
    class Node {
        Node prev;
        Node next;
        int value;
        int key;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> hs = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);;
    private Node tail = new Node(-1, -1);;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!hs.containsKey(key)) {
            return -1;
        }

        Node current = hs.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        move_to_tail(current);
        return current.value; 
    }

    public void set(int key, int value) {
        if (get(key) != -1) {
            hs.get(key).value = value;
            return;
        }

        if (hs.size() == capacity) {
            hs.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node insert = new Node(key, value);
        hs.put(key, insert);
        move_to_tail(insert);
    }

    private void move_to_tail(Node current) {

        current.prev = tail.prev;
        current.next = tail;
        tail.prev.next = current;
        tail.prev = current;
    }

}
