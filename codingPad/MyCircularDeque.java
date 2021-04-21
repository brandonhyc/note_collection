package codingPad;

import java.util.StringJoiner;

class MyCircularDeque {

//	/ Initialize your data structure here. Set the size of the deque to be k. /

	int capacity;
	int head;
	int tail;
	int[] array;

	// stored numbers are in (head, tail)
	public MyCircularDeque(int k) {
		if (k == 0) {
			return;
		}
		head = 0;
		tail = 1;
		capacity = k;
		array = new int[k + 1];
	}

//	/
//	  Adds an item at the front of Deque. Return true if the operation is
//	  successful.
//	 /
	public boolean insertFront(int value) {
		if (isFull()) {
			return false;
		}

		array[tail] = value;
		tail = (tail + 1) % (capacity + 1);

		return true;
	}
//
//	/
//	  Adds an item at the rear of Deque. Return true if the operation is
//	  successful.
//	 /
	public boolean insertLast(int value) {
		if (isFull()) {
			return false;
		}

		array[head] = value;
		head = (head != 0) ? head - 1 : capacity;

		return true;
	}

//	/
//	  Deletes an item from the front of Deque. Return true if the operation is
//	  successful.
//	 /
	public boolean deleteFront() {
		if (isEmpty()) {
			return false;
		}

		tail = (tail != 0) ? tail - 1 : capacity;
		return true;
	}

//	/
//	  Deletes an item from the rear of Deque. Return true if the operation is
//	  successful.
//	 /
	public boolean deleteLast() {
		if (isEmpty()) {
			return false;
		}
		head = (head + 1) % (capacity + 1);
		return true;
	}

//	/ Get the front item from the deque. /
	public int getFront() {
		if (isEmpty()) {
			return -1;
		}
		int temp = (tail - 1) % (capacity + 1);
		return array[temp];
	}

//	/ Get the last item from the deque. /
	public int getRear() {
		if (isEmpty()) {
			return -1;
		}
		int temp = (head + 1) % (capacity + 1);
		return array[temp];
	}

//	/ Checks whether the circular deque is empty or not. /
	public boolean isEmpty() {
		return head + 1 == tail;
	}

//	/ Checks whether the circular deque is full or not. /
	public boolean isFull() {
		return head == tail;
	}

	public static void runTest1() {

		MyCircularDeque deque = new MyCircularDeque(5);
		boolean param_1 = deque.insertFront(1);
		boolean param_2 = deque.insertLast(2);
		boolean param_3 = deque.insertLast(3);
		boolean param_4 = deque.insertLast(4);
		boolean param_5 = deque.insertLast(5);
		boolean param_6 = deque.insertLast(6);
		boolean param_7 = deque.insertLast(7);
		boolean param_8 = deque.deleteFront();
		boolean param_9 = deque.deleteLast();
		int param_10 = deque.getFront();
		int param_11 = deque.getRear();
		boolean param_12 = deque.isEmpty();
		boolean param_13 = deque.isFull();
		
		
		MyCircularDeque circularDeque = new MyCircularDeque(5);
		circularDeque.insertLast(1);
		circularDeque.insertLast(2);
		circularDeque.insertFront(3);
		circularDeque.insertFront(4);
		
		System.out.println(circularDeque.getRear());
	}
	
	public static void runTest2() {
		MyCircularDeque circularDeque = new MyCircularDeque(3); // set the size to be 3
		circularDeque.insertLast(1);            // return true
		circularDeque.insertLast(2);            // return true
		circularDeque.insertFront(3);            // return true
		circularDeque.insertFront(4);            // return false, the queue is full
		circularDeque.getRear();              // return 2
		circularDeque.isFull();                // return true
		circularDeque.deleteLast();            // return true
		circularDeque.insertFront(4);            // return true
		circularDeque.getFront();            // return 4
		
		
	}

	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(" ");
		int temp = (head + 1) % (capacity + 1);
		while (temp != tail) {
			sj.add(String.valueOf(array[temp]));
			temp = (temp + 1) % (capacity + 1);
		}
		return sj.toString();
	}
}

/*
  input:
  circularDeque.insertLast(1),circularDeque.insertLast(2),
  circularDeque.insertFront(3),circularDeque.insertFront(4),
  circularDeque.getRear()
  output: false expected:<2> but was:<3>



  input: circularDeque.insertLast(1),circularDeque.insertLast(2),
  circularDeque.insertFront(3),circularDeque.insertFront(4),
  circularDeque.getRear(),circularDeque.isFull(), circularDeque.deleteLast(),
  circularDeque.insertFront(4),circularDeque.getFront() output: 1 expected:<4>
  but was:<1>


*/