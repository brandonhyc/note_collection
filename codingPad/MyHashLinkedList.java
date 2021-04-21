package codingPad;

import java.util.HashMap;
import java.util.Map;

public class MyHashLinkedList<K, V> {
	Map<K, Node<V>> map;
	Node<V> head, tail;
	int capacity;
	int size;

	// Map<Key, Node>
	// DoubleLinkedList

	public MyHashLinkedList(int capacity) {
		this.map = new HashMap<>();
		this.capacity = capacity;
		this.size = 0;
		head = new Node<>(null);
		tail = new Node<>(null);
		head.next = tail;
		tail.prev = head;
	}

	public void set(K key, V value) {
		// if exist, update and move
		// if not exist,
		// if not full add,
		// if full, evict, add
		if (isFull()) {
			evict();
		}
		Node<V> node = new Node<>(value);
		map.put(key, node);
		offer(node);
		size++;
	}

	private Node<V> poll(Node<V> node) {
		Node<V> oldPrev = node.prev;
		Node<V> oldNext = node.next;
		oldPrev.next = oldNext;
		oldNext.prev = oldPrev;

		node.next = null;
		node.prev = null;
		return node;
	}

	private void evict() {
		Node<V> oldTail = tail.prev;
		poll(oldTail);
		oldTail.val = null;
		size--;
	}

	private void offer(Node<V> node) {
		Node<V> oldHead = head.next;

		head.next = node;
		node.prev = head;
		oldHead.prev = node;
		node.next = oldHead;
	}

	public V get(K key) {
		// if not exist, return null
		// if exist, poll, and add
		Node<V> node = map.get(key);
		if (node != null && node.val != null) {
			poll(node);
			offer(node);
			return node.val;
		}

		return null;
	}
	
	private boolean isFull() {
		return size == capacity;
	}

	private static class Node<V> {
		Node<V> prev, next;
		V val;

		public Node(V value) {
			this.val = value;
		}

		@Override
		public String toString() {
			return "[val=" + val + "]";
		}
	}
	
	static public void test() {
		MyHashLinkedList<Integer, Integer> lru = new MyHashLinkedList<>(5);
		System.out.println(lru.get(1));
		lru.set(1, 1);
		System.out.println(lru.get(1));
		lru.set(2, 2);
		System.out.println(lru.get(1));
		lru.set(3, 3);
		lru.set(4, 4);
		System.out.println(lru.get(3));
		lru.set(5, 5);
		System.out.println(lru.get(5));
		System.out.println(lru.get(1));
		lru.set(6, 6);
		System.out.println(lru.get(3));
		System.out.println(lru.get(5));
		lru.set(8, 8);
		System.out.println(lru.get(1));
		System.out.println(lru.get(6));
	}
	
	static public void test1() {
		MyHashLinkedList<Integer, Integer> lru = new MyHashLinkedList<>(3);
		System.out.println(lru.get(1)); // null
		lru.set(1, 1); // 1
		System.out.println(lru.get(1));
		lru.set(2, 2); // 2,1
		System.out.println(lru.get(1));
		lru.set(3, 3);
		lru.set(4, 4); // 4,3,2
		System.out.println(lru.get(3)); // 3,4,2
		lru.set(5, 5); // 5,3,4
		System.out.println(lru.get(5)); // 5
		System.out.println(lru.get(1)); // null
		lru.set(6, 6); // 6,5,3
		System.out.println(lru.get(3)); // 3
		System.out.println(lru.get(5)); // 5,  5,3,6
		System.out.println(lru.get(4)); // null
		lru.set(8, 8); // 8,5,3
		System.out.println(lru.get(1));
		System.out.println(lru.get(6));
		System.out.println(lru.get(8));
	}


	
//	input: capactity=5;
//	get(1),set(1,1),           null
//	get(1),set(2,2),           1             2,1
//	get(1),                    1             1,2
//	get(2),set(3,3),set(4,4),  2             4,3,2,1
//	get(3),set(5,5),           3             5,3,4,2,1
//	get(5),                    5             5,3,4,2,1
//	get(1), set(6,6),          1             6,5,3,4,2
//	get(2),                    2             2,6,5,3,4
//	get(4),set(7,7),           4             4,2,6,5,3
//	get(3),                    3             3,4,2,6,5
//	get(5),set(8,8),           4             5,3,4,2,6
//	get(1),                    n             
//	get(6)                     6             6,5,3,4,2
//	output: [null, 1, 1, 2, 3, 5, 1, null, 4, 3, 5, 1, 6]
//	expected:<[null, 1, 1, 2, 3, 5, 1, null, 4, null, 5, null, 6]> but was:<[null, 1, 1, 2, 3, 5, 1, null, 4, 3, 5, 1, 6]>
}
