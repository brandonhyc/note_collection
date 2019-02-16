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
    Map map = new HashMap<>();
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
        tail.prev = this.tail;

        return cur.value;
    }
    
    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            this.map.get(key).vaule = value;
            return;
        }

        Node node = new Node(value);
        if (this.capacity == this.map.size()) {
            Node leastUsedNode = head.next;
            this.map.remove(leastUsedNode);

            head.next = 

        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */