package codingPad;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
	  Deque<Integer> stack1;
	  Deque<int[]> stack2;
	  final int VALUE = 0;
	  final int INDEX = 1;

	  public MinStack() {
	    stack1 = new ArrayDeque<>();
	    stack2 = new ArrayDeque<>();
	  }
	  
	  public int pop() {
	    if (stack1.isEmpty()) {
	      return -1;
	    }
	    int res = stack1.pollFirst();
	    if (stack1.size() == stack2.peekFirst()[INDEX]) {
	      stack2.pollFirst();
	    }
	    return res;
	  }
	  
	  // [  5        4       
	  // [  <5, 0>  <4, 1>

	  public void push(int element) {
	    stack1.offerFirst(element);
	    
	    if (stack2.isEmpty() || stack2.peekFirst()[VALUE] > element) {
	      stack2.offerFirst(new int[] {element, stack1.size() - 1 });
	    }

	    return;
	  }
	  
	  public int top() {
	    if (stack1.isEmpty()) {
	      return -1;
	    }
	    return stack1.peekFirst();
	  }
	  
	  public int min() {
	    if (stack2.isEmpty()) {
	      return -1;
	    }
	    return stack2.peekFirst()[VALUE];
	  }
	  static void runTest() {
		  MinStack s1 = new MinStack();
		  
		  s1.push(5);
		  s1.top();
		  s1.min();
		  s1.pop();
		  s1.min();
		  s1.top();
		  
	  }
}
