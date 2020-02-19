class LRUCache {
    
    ListNode head;
    ListNode tail;
    
    class ListNode {
        ListNode prev;
        ListNode next;
        int key;
        int value;
        ListNode(int key, int val) {
            value = val;
            this.key = key;
        }
    }
    int cap = 0;
    Map<Integer, ListNode> map;
    public LRUCache(int capacity) {
        cap = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        
        // System.out.printf("before getting key: %d\n", node.key);
        // print(head);
        // printT(tail);
        // take it out
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
        // System.out.printf("its prev: %d, next: %d\n", prev.key, next.key);
        
        // System.out.printf("after getting taking out %d\n", node.key);
        // print(head);
        
        // put to tail
        ListNode temp = tail.prev;
        temp.next = node;
        node.prev = temp;
        node.next = tail;
        tail.prev = node;
        // System.out.printf("after putting to tail%d\n", node.key);

        // print(head);
        
        return node.value;
    }
    
    private void print(ListNode head) {
        while (head != null) {
            System.out.printf("%d->", head.key);
            head = head.next;
        }
        System.out.println(" ");
    }
    private void printT(ListNode tail) {
        while (tail != null) {
            System.out.printf("%d<-", tail.key);
            tail = tail.prev;
        }
        System.out.println(" ");
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            get(key);
            return;
        }
        
        ListNode node = new ListNode(key, value);
        map.put(key, node);
        // get tail - 1
        ListNode temp = tail.prev;
        temp.next = node;
        node.prev = temp;
        tail.prev = node;
        node.next = tail;
        
        // evict head + 1
        if (map.size() > cap) {
            // System.out.printf("put key: %d, evict key: %d\n", node.key, head.next.key);
            map.remove(head.next.key);
            ListNode prev = head;
            ListNode next = head.next.next;
            prev.next = next;
            next.prev = prev;
            
        }
        // System.out.printf("putting key: %d\n", node.key);
        // print(head);
        // printT(tail);

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */