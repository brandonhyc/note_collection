class LRUCache {
    
    class ListNode {
        ListNode prev = null;
        ListNode next = null;
        int value = 0;
        int key = 0;
        
        ListNode() {
        }
    }
    
    ListNode dummyFirst = null;
    ListNode dummyLast = null;
    int capacity = 0;
    HashMap<Integer, ListNode> map = new HashMap<>();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        
        this.dummyFirst = new ListNode();
        this.dummyLast = new ListNode();
        
        this.dummyFirst.next = this.dummyLast;
        this.dummyLast.prev = this.dummyFirst;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        ListNode target = map.get(key);
        ListNode prev = target.prev;
        ListNode next = target.next;
        ListNode temp = new ListNode();
        
        // take it out from the list
        temp = prev;
        prev.next = next;
        next.prev = temp;
        
        // move the known node to the last of LinkedList
        temp = this.dummyLast.prev;
        this.dummyLast.prev = target;
        target.next = this.dummyLast;
        target.prev = temp;
        temp.next = target;
        
        return target.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            // priorize it
            get(key);
            return;
        }
        
        ListNode node = new ListNode(); 
        ListNode temp = new ListNode();
        
        node.value = value;
        node.key = key;
        map.put(key, node);
        
        temp = this.dummyLast.prev;
        this.dummyLast.prev = node;
        temp.next= node;
        
        node.next = this.dummyLast;
        node.prev = temp;
        
        if (capacity < this.map.keySet().size()) {
            ListNode target = this.dummyFirst.next;
            temp = null;
            
            temp = target.next;
            target.next.prev = this.dummyFirst;
            this.dummyFirst.next = temp;
            
            map.remove(target.key);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */