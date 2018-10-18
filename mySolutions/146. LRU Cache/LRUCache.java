public class LRUCache {
    /*
    * @param capacity: An integer
    */

    class ListNode {
        public int key, val;
        public ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    private int capacity, size;
    private ListNode dummy, tail;
    private Map<Integer, ListNode> keyToPrev;

    public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        this.keyToPrev = new HashMap<Integer, ListNode>();
        this.dummy = new ListNode(0, 0);
        this.tail = this.dummy;
    }

    private void moveToTail(int key) {
        ListNode prev = keyToPrev.get(key);
        ListNode curt = prev.next;

        if (tail == curt) {
            return;
        }
        prev.next = prev.next.next;


    }
    /* get(key) 
     *      Get the value (will always be positive) of 
     *      the key if the key exists in the cache, otherwise return -1.
     * @param key: An integer
     * @return: An integer
     * 
     *
     */
    public int get(int key) {
        // write your code here
        if (!keyToPrev.containsKey(key)) {
            return -1;
        }

        moveToTail(key);
        return tail.val;
    }

    /* set(key, value) - 
     *      Set or insert the value if the key is not already present. 
     *      When the cache reached its capacity, 
     *      it should invalidate the least recently used item before inserting a new item.
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (get(key) != -1) {
            ListNode prev = keyToPrev.get(key);
            prev.next.val = value;
            return;
        }

        if (size < capacity) {
            size++;
            ListNode curt = new ListNode(key, value);
            tail.next = curt;
            keyToPrev.put(key, tail);

            tail = curt;
            return;
        }

        ListNode first = dummy.next;
        keyToPrev.remove(first.key);

        first.key = key;
        first.val = value;
        keyToPrev.put(key, dummy);
        
        moveToTail(key);

    }
}