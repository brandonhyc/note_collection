class LRUCache {
    private class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }


    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node cur = map.get(key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;

        //move to tail

        Node temp = this.tail.prev;
        
        this.tail.prev.next = cur;
        cur.next = tail;
        cur.prev = temp;
        tail.prev = cur;

        return cur.value;
    }
    
    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            Node cur = this.map.get(key);
            cur.value = value;


            this.tail.prev.next = cur;
            cur.next = tail;
            cur.prev = temp;
            tail.prev = cur;
            return;
        }
        if (this.capacity == this.map.size()) {
            Node leastUsedNode = head.next;
            this.map.remove(leastUsedNode.key);
            head.next = leastUsedNode.next;
            leastUsedNode.next.prev = head;
        }

        Node cur = new Node(key, value);
        this.map.put(key, cur);
        
        //move to tail
        Node temp = this.tail.prev;
        this.tail.prev.next = cur;
        cur.next = tail;
        cur.prev = temp;
        tail.prev = cur;
        return;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */