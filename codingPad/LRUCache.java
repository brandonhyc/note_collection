package codingPad;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    int capacity;
    Map<Integer, Node> map;
    Node head, tail; // pop from head, enqueue from tail

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // 1. get return val by getting the node
        // 2. move the target node to the tail

        Node resNode = map.get(key);
        if (resNode == null) return -1;

        // cut the node from the list
        resNode.next.prev = resNode.prev;
        resNode.prev.next = resNode.next;

        // insert resNode between [preTail --V-> Tail]
        moveToTail(resNode);
        return resNode.val;
    }

    private void moveToTail(Node node) {
        Node prevTail = tail.prev;
        node.next = tail;
        node.prev = prevTail;
        tail.prev =  node;
        prevTail.next = node;
    }

    public void put(int key, int value) {
        // 1. create new Node
        // 2. insert it to the tail
        // 3. evict if out of capacity
        Node newNode = map.get(key);
        if (newNode != null) {
            newNode.val = value;
            // cut the node from the list
            newNode.next.prev = newNode.prev;
            newNode.prev.next = newNode.next;
        } else {
            newNode = new Node();
            newNode.id = key;
            newNode.val = value;
            map.put(key, newNode);
        }

        // insert resNode between [preTail --V-> Tail]
        moveToTail(newNode);

        if (capacity < map.size()) {
            // evict from queue
            // evict from map
            // cap--
            Node removal = head.next;
            Node headNext = removal.next;
            head.next = headNext;
            headNext.prev = head;

            removal.next = null;
            removal.prev = null;

            map.remove(removal.id);
        }
    }

    private static class Node {
        int id;
        int val;
        Node prev, next;
        public Node() { }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}