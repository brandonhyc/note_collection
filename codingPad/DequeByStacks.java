package codingPad;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeByStacks {
	// Deque: offerFirst, offerLast, pollFirst, pollLast, size, isEmpty, 
	
	Deque<Integer> head;
	Deque<Integer> tail;
	
	public DequeByStacks() {
		head = new ArrayDeque<>();
		tail = new ArrayDeque<>();
		
	}
	
	public void offerFirst(int element) {
		head.offerFirst(element);
	}
	
	public void offerLast(int element) {
		tail.offerFirst(element);
	}
	
	public int pollFirst() {
		if (head.isEmpty() && tail.isEmpty()) {
			return -1;
		}
		if (head.isEmpty()) {
			move(tail, head);
		}
		
		return head.pollFirst();
	}
	
	public int pollLast() {
		if (head.isEmpty() && tail.isEmpty()) {
			return -1;
		}
		if (tail.isEmpty()) {
			move(head, tail);
		}
		return tail.pollFirst();
	}
	
	public int peekFirst() {
		if (head.isEmpty() && tail.isEmpty()) {
			return -1;
		}
		if (head.isEmpty()) {
			move(tail, head);
		}
		return head.peekFirst();
	}
	
	public int peekLast() {
		if (head.isEmpty() && tail.isEmpty()) {
			return -1;
		}
		if (tail.isEmpty()) {
			move(head, tail);
		}
		return tail.peekFirst();
	}
	
	public int size() {
		return head.size() + tail.size();
	}
	
	public boolean isEmpty() {
		return head.isEmpty() && tail.isEmpty();
	}
	
	private void move(Deque<Integer> one, Deque<Integer> two) {
		Deque<Integer> buffer = new ArrayDeque<>();
		
		// buffer top half
		for (int i = 0; i < one.size() / 2; i++) {
			buffer.offerFirst(one.pollFirst());
		}
		// move the bottom half to s2
		
		while (!one.isEmpty()) {
			two.offerFirst(one.pollFirst());
		}
		// move the top half back to s1
		
		while (!buffer.isEmpty()) {
			one.offerFirst(buffer.poll());
		}
	}
	

// 188 217 ||
// 217 || 
	
	//[offerLast()#217, peekFirst(), offerFirst()#188, pollLast(), isEmpty(), offerLast()#77, offerLast()#234, peekLast(), pollFirst()]
	//expected:<[offerLast(217), 217, offerFirst(188), 217, false, offerLast(77), offerLast(234), 234, 188]> 
	// but was:<[offerLast(217), 217, offerFirst(188), null, false, offerLast(77), offerLast(234), 234, 188]>
	
	static void runTest1() {
		DequeByStacks deque = new DequeByStacks();
		deque.offerLast(217);
		System.out.println(deque.peekFirst());
		deque.offerFirst(188);
		System.out.println(deque.pollLast());

		System.out.println(3 == deque.pollFirst());
		System.out.println(2 == deque.pollFirst());
		System.out.println(1 == deque.pollFirst());
		System.out.println(4 == deque.pollFirst());
		System.out.println(5 == deque.pollFirst());
		System.out.println(6 == deque.pollFirst());

	}
	
	
	static void runTest2() {
		DequeByStacks deque = new DequeByStacks();
		deque.offerFirst(1);
		deque.offerFirst(2);
		deque.offerFirst(3);
		deque.offerLast(4);
		deque.offerLast(5);
		deque.offerLast(6);

		System.out.println(3 == deque.pollFirst());
		System.out.println(2 == deque.pollFirst());
		System.out.println(1 == deque.pollFirst());
		System.out.println(4 == deque.pollFirst());
		System.out.println(5 == deque.pollFirst());
		System.out.println(6 == deque.pollFirst());

	}


	@Override
	public String toString() {
		return "DequeByStacks [head=" + head + ", last=" + utils.reverseString(tail.toString()) + "]";
	}

}
