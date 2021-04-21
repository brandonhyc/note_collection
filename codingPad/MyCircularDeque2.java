package codingPad;

class GenericCircularDeque<T> {

    T[] array;
    int start = -1, end = -1;
//    / Initialize your data structure here. Set /**/the size of the deque to be k. /
    public GenericCircularDeque(int k) {
        if (k <= 1) System.out.println("size too small");
        array = (T[]) new Object[k + 1];
        start = 0;
        end = 1;
    }

//    / Adds an item at the front of Deque. Return true if the operation is successful. /
    public boolean insertFront(T value) {
        if (start == end) return false;
        array[start] = value;
        start = start - 1 == -1 ? array.length - 1 : start - 1;
        return true;
    }

//    / Adds an item at the rear of Deque. Return true if the operation is successful. /
    public boolean insertLast(T value) {
        if (start == end) return false;
        array[end] = value;
        end = (end + 1) % array.length;
        return true;
    }

//    / Deletes an item from the front of Deque. Return true if the operation is successful. /
    public boolean deleteFront() {
        if (isEmpty()) return false;
        start = (start + 1) % array.length;
        return true;
    }

//    / Deletes an item from the rear of Deque. Return true if the operation is successful. /
    public boolean deleteLast() {
        int nextEnd = (end - 1) == -1 ? array.length - 1 : end - 1;
        if (nextEnd == start) return false;
        end = nextEnd;
        return true;
    }

//    / Get the front item from the deque. /
    public T getFront() {
        if (isEmpty()) return null;
        return array[(start + 1) % array.length];
    }

//    / Get the last item from the deque. /
    public T getRear() {
        int prevEnd = (end - 1) == -1 ? array.length - 1 : end - 1;
        if (prevEnd == start) return null;

        return array[prevEnd];
    }

//    / Checks whether the circular deque is empty or not. /
    public boolean isEmpty() {
        int prevEnd = (end - 1) == -1 ? array.length - 1 : end - 1;
        return prevEnd == start;
    }

//    / Checks whether the circular deque is full or not. /
    public boolean isFull() {
        return start == end;
    }
}

