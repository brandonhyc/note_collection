package codingPad;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueByTwoStacks_31 {

	Deque<Integer> stack1; // for storing the input
	Deque<Integer> stack2; // for popping output

	@Override
	public String toString() {
		return this.stack1.toString() + this.stack2.toString();
	}
	
	public QueueByTwoStacks_31() {
		// Write your solution here.
		this.stack1 = new ArrayDeque<>(); // for storing the input
		this.stack2 = new ArrayDeque<>(); // for poping output

	}
	  
	  public Integer poll() {
	    if (stack1.isEmpty() && stack2.isEmpty()) {
	      return null;
	    }
	    if (stack2.isEmpty()) {
	      move();
	    }
	    return stack2.pollFirst();
	  }

	  private void move() {
	      while (!stack1.isEmpty()) {
	        stack2.offerFirst(stack1.pollFirst());
	      }
	  }
	  
	  public void offer(int element) {
	    stack1.offerFirst(element);
	  }
	  
	  public Integer peek() {
	    if (stack1.isEmpty() && stack2.isEmpty()) {
	      return null;
	    }
	    if (stack2.isEmpty()) {
	      move();
	    }
	    return stack2.peekFirst();
	  }
	  
	  public int size() {
	    return stack1.size() + stack2.size();
	  }
	  
	  public boolean isEmpty() {
	    return stack1.isEmpty() && stack2.isEmpty();
	  }
	
	public static void runTest1() {
		QueueByTwoStacks_31 s1  = new QueueByTwoStacks_31();
		System.out.println(s1.toString());
		s1.offer(2);
		System.out.println(s1.toString());
		s1.offer(3);
		System.out.println(s1.toString());
		System.out.println(s1.peek());
		System.out.println(s1.toString());
		System.out.println(s1.poll());
		System.out.println(s1.toString());
		s1.offer(1);
		System.out.println(s1.toString());
		
		System.out.println(s1.poll());
		System.out.println(s1.peek());
		System.out.println(s1.poll());
		
		s1.offer(1);
		s1.offer(2);
		s1.offer(3);
		s1.offer(4);
		s1.offer(5);
		s1.offer(6);
		s1.offer(7);
		s1.offer(8);
		
		System.out.println(s1);
		while (s1.size() != 0) {
			System.out.println(s1.poll());
		}
		System.out.println(s1.poll());
		
	}
}
