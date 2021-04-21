package codingPad;

import java.util.*;

public class MyHashMap<K extends Object, V> extends AbstractMap<K, V> {

	private static float DEFAULT_LOAD_FACTOR = 0.75f;
	private int size;
	private int capacity;
	private Node<K, V>[] bucket;

	public MyHashMap(int capacity) {
		if (capacity >= 0) {
			this.bucket = new Node[capacity + 1];
			this.capacity = capacity;
		}
		List<int[]> arr = new ArrayList<>();
		Map<K,V> map = new HashMap<>();
	}

	private void rehash() {
		Node<K, V>[] newBucket = new Node[capacity * 2 + 1];
		capacity = capacity * 2 + 1;
		for (Node<K, V> head : bucket) {
			while (head != null) {
				Node<K, V> next = head.next;
				put(head.key, head.value, newBucket);
			}
		}
		bucket = newBucket;
	}

	private V put (K key, V value, Node[] bucket) {
		int index = key.hashCode() % bucket.length;
		Node<K, V> curr = bucket[index];
		if (curr == null) {
			bucket[index] = new Node(key, value);
		} else {
			Node<K, V> prev = null;
			while (curr != null) {
				if (Objects.equals(curr.key, key)) {
					V oldValue = curr.value;
					curr.value = value;
					return oldValue;
				} else {
					prev = prev.next;
					curr = curr.next;
				}
			}
			if (curr == null) {
				prev.next = new Node(key, value);
				size += 1;
			}
		}
		return null;
	}

	public V put(K key, V value) {
		if ((size + 1) / capacity >= DEFAULT_LOAD_FACTOR) {
			rehash();
		}

		return put(key, value, bucket);
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		return null;
	}

	@Override
	public V get(Object key) {
		int index = key.hashCode() % bucket.length;
		Node<K, V> curr = bucket[index];
		while (curr != null) {
			if (curr.key.equals(key)) {
				break;
			} else {
				curr = curr.next;
			}
		}
		return curr != null ? curr.value : null;
	}

	@Override
	public V remove(Object key) {
		int index = key.hashCode() % bucket.length;
		Node<K, V> prev = null;
		Node<K, V> curr = bucket[index];
		if (Objects.equals(key, curr.key)) { // TODO: this is because it supports null as KEY
			bucket[index] = curr.next;
			size -= 1;
			curr.next = null;
			return curr.value;
		} else {
			while (curr != null) {
				if (Objects.equals(key, curr.key)) {
					break;
				} else {
					curr = curr.next;
					prev = prev.next;
				}
			}
			if (curr != null) {
				prev.next = curr.next;
				size -= 1;
				curr.next = null;
				return curr.value;
			}
		}

		return null;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		MyHashMap<?, ?> myHashMap = (MyHashMap<?, ?>) o;
		return size == myHashMap.size &&
				capacity == myHashMap.capacity &&
				Arrays.equals(bucket, myHashMap.bucket);
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(super.hashCode(), size, capacity);
		result = 31 * result + Arrays.hashCode(bucket);
		return result;
	}

	private static class Node<K, V> {
		K key;
		V value;
		Node<K, V> next;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
}
