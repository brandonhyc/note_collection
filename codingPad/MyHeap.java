package codingPad;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class MyHeap {
	private Comparator<Integer> comparator;
	private int[] array;
	private int size;
	private static int DEFAULT_CAPACITY = 11;

	public MyHeap() {
		this.comparator = Comparator.<Integer>naturalOrder();
		size = 0;
		array = new int[DEFAULT_CAPACITY];
	}

	public MyHeap(int[] array) {
		this.comparator = Comparator.<Integer>naturalOrder();
		this.array = array;
		size = array.length;

		heapify(0, size - 1);
	}

	public Comparator<Integer> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<Integer> comparator) {
		this.comparator = comparator;
	}

	public void heapify(int start, int end) {
		// basic idea: given the left child and right child are heap, the root needs to
		// be percolated down
		for (int i = (end - 1) / 2; i >= start; i--) {
			percolateDown(i);
		}
	}

	public Integer poll() {
		if (size == 0) {
			throw new NoSuchElementException("the heap is empty");
		}

		int res = array[0];
		swap(0, size - 1);
		size--;
		percolateDown(0);

		return res;
	}

	private void percolateDown(int root) {
		while (root * 2 + 1 <= size - 1) { // <= size / 2
			int min = root * 2 + 1;
			if (min + 1 < size && comparator.compare(array[min + 1], array[min]) < 0) {
				min = min + 1;
			}
			if (comparator.compare(array[min], array[root]) < 0) {
				swap(root, min);
				root = min;
			} else {
				break;
			}
		}
	}

	private void swap(int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public boolean isEmpty() {
		return size == 0;
	}
}