package codingPad;

import java.util.Comparator;

public class HeapImpl<E> implements Heap<E>{
    final int DEFAULT_SIZE = 10;
    E[] array;
    Comparator<E> comparator;
    int size = 0;

    public HeapImpl(Comparator<E> cp) {
        this.array = (E[]) new Object[DEFAULT_SIZE];
        this.comparator = cp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            // throw exception
        }
        return array[0];
    }

//    /
//      Heapify
//     /
    @Override
    public E poll() {
        if (isEmpty()) {
            // throw
        }
        E res = array[0];
        // poll the head and then swap the last child to the head, and percolate down until at the correct place
        swap(0, size - 1);
        size--;

        int curr = 0;
        while (2 * curr + 1 <= size - 1) {
            int leftChild = 2 * curr + 1;
            int min = leftChild;
            if (leftChild + 1 <= size - 1 && comparator.compare(array[leftChild], array[leftChild + 1]) > 0) {
                min = leftChild + 1;
            }
            if (comparator.compare(array[curr], array[min]) <= 0) {
                break;
            }
            swap(curr, min);
            curr = min;
        }

        return res;
    }

    @Override
    public void offer(E ele) {
        array[size] = ele;
        int curr = size;

        // keep percolate up until it's at the right place
        while ((curr - 1) / 2 >= 0) {
            int parent = (curr - 1) / 2;;
            if (comparator.compare(array[curr], array[parent]) >= 0) {
                break;
            }
            swap(curr, parent);
            curr = parent;
        }
        size++;
    }

    private void swap(int left, int right) {
        E temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    @Override
    public void update(int index, Object elm) {

    }
}
