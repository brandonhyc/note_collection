package codingPad;

import java.util.StringJoiner;

class CircularQueueByArray {

	private int first;
	private int last;
	private int capacity;
	private int[] array;

//	/ Initialize your data structure here. Set the size of the queue to be k. /
	public CircularQueueByArray(int k) {
		if (k == 0) {
			return;
		}

		this.capacity = k;
		this.array = new int[k + 1];
		first = 0;
		last = 1;

	}

//	/
//	  Insert an element into the circular queue. Return true if the operation is
//	  successful.
//	 /
	public boolean enQueue(int value) {
		if (isFull()) {
			return false;
		}

		array[last] = value;
		last = (last + 1) % (capacity + 1);

		return true;

	}

//	/
//	  Delete an element from the circular queue. Return true if the operation is
//	  successful.
//	 /
	public boolean deQueue() {
		if (isEmpty()) {
			return false;
		}

		first = (first + 1) % (capacity + 1);

		return true;
	}

//	/ Get the front item from the queue. /
	public int Front() {
		if (isEmpty()) {
			return -1;
		}
		return array[(first + 1) % (capacity + 1)];

	}

//	/ Get the last item from the queue. /
	public int Rear() {
		if (isEmpty()) {
			return -1;
		}
		return array[(last - 1) < 0 ? capacity : last - 1];

	}

//	/ Checks whether the circular queue is empty or not. /
	public boolean isEmpty() {
		return (first + 1) % (capacity + 1) == last;
	}

//	/ Checks whether the circular queue is full or not. /
	public boolean isFull() {
		return first == last;
	}
	
	

	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(" ");
		int temp = (first + 1) % (capacity + 1);
		while (temp != last) {
			sj.add(String.valueOf(array[temp]));
			temp = (temp + 1) % (capacity + 1);
		}
		return sj.toString();
	}

	static public void runTest1() {
		
		CircularQueueByArray queue = new CircularQueueByArray(5);
		
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		System.out.println(queue.isFull());
		queue.enQueue(1);
		System.out.println(queue.deQueue());
		System.out.println(queue.Front());
		System.out.println(queue.Rear());
		System.out.println(queue.Rear());
		System.out.println(queue.isEmpty());

	}
}

///
//  Your MyCircularQueue object will be instantiated and called as such:
//  MyCircularQueue obj = new MyCircularQueue(k); boolean param_1 =
//  obj.enQueue(value); boolean param_2 = obj.deQueue(); int param_3 =
//  obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty();
//  boolean param_6 = obj.isFull();
// /