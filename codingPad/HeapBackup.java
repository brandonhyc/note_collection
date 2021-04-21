package codingPad;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

//Implementation Of Capacity Limited Min Heap Empty version:
public class HeapBackup {
	private int[] array;
	private int size;
	private Comparator<Integer> comparator;
	
	public HeapBackup(int[] array, Comparator<Integer> comparator) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("input array can not be null or empty");
		}
		this.comparator = comparator;
		this.array = array;
		size = array.length;
		heapify();
		
	}
	
	public HeapBackup(int[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("input array can not be null or empty");
		}
		this.comparator = Comparator.<Integer>naturalOrder();
		this.array = array;
		size = array.length;
		heapify();
	}

	private void heapify() {
		// parent of last leaf: size / 2 - 1
		for (int i = size / 2 - 1; i >= 0; i--) {
			percolateDown(i);
		}
	}

	public HeapBackup(int cap) {
		if (cap <= 0) {
			throw new IllegalArgumentException("can not be null or empty");
		}
		array = new int[cap];
		size = 0;

	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == array.length;
	}

	private void percolateUp(int index) {

		while (index > 0) {
			int parent = (index - 1) / 2;
			if (comparator.compare(array[parent], array[index]) > 0) {
				swap(index, parent);
				index = parent;
			} else {
				break;
			}
		}
	}

	private void percolateDown(int index) {
		while ((2 * index + 1) < size) {
			int swapCandidate = 2 * index + 1;
			if (swapCandidate + 1 < size && comparator.compare(array[swapCandidate], array[swapCandidate + 1]) > 0) {
				swapCandidate += 1;
			}
			if (comparator.compare(array[swapCandidate], array[index]) < 0) {
				swap(index, swapCandidate);
				index = swapCandidate;
			} else {
				break;
			}
		}
	}

	public int peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("heap is empty");
		}
		return array[0];
	}

	public int poll() {
		if (isEmpty()) {
			throw new NoSuchElementException("heap is empty");
		}
		int res = array[0];
		swap(0, size - 1);
		size -= 1;
		percolateDown(0);
		return res;
	}

	public void offer(int ele) {
		if (isFull()) {
			array = Arrays.copyOf(array, (int) (array.length * 1.5 + 1));
		}
		size += 1;
		array[size - 1] = ele;
		percolateUp(size - 1);
	}

	public void update(int index, int ele) {
		if (index >= size) {
			throw new ArrayIndexOutOfBoundsException("invalid index range");
		}
		array[index] = ele;
		percolateUp(index);
		percolateDown(index);
	}

	private void swap(int l, int r) {
		int tmp = array[l];
		array[l] = array[r];
		array[r] = tmp;
	}

}
