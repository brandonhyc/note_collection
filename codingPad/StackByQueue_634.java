package codingPad;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackByQueue_634 {
	 
    Deque<Integer> queue;

    public StackByQueue_634() {
         queue = new ArrayDeque<>();
    }

//    / Push element x onto stack. /
    public void push(int x) {
        queue.offerLast(x);
    }

//    / Removes the element on top of the stack and returns that element. /
    public Integer pop() {
        if (queue.size() == 0) {
          return null;
        }
        // re-enter all numbers back to queue except the latest one
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
          queue.offerLast(queue.pollFirst());
        }

        return queue.pollFirst();
    }

//    / Get the top element. /
    public Integer top() {
        if (queue.size() == 0) {
          return null;
        }

        int temp = pop();
        queue.offerLast(temp);
        
        return temp;

    }

//    / Returns whether the stack is empty. /
    public boolean isEmpty() {
       return queue.size() == 0;
    }
    
    public static void runTest1() {
//    	Input:   [push(1), push(2), push(3), pop(), pop(), push(4), push(5), pop(), pop(), pop(), pop(), top(), isEmpty()] 
//    	expect :<["push(1)", "push(2)", "push(3)", "3", "2", "push(4)", "push(5)", "5", "4", "1", null, null, "true"]> 
//    	but was:<["push(1)", "push(2)", "push(3)", "1", "2", "push(4)", "push(5)", "3", "4", "5", null, null, "true"]>
    	StackByQueue_634 s1 = new StackByQueue_634();
    	
    	s1.push(1); 
    	s1.push(2); 
    	s1.push(3); 
    	s1.isEmpty(); 
    	s1.top(); 
    	s1.pop(); 
    	s1.isEmpty(); 
    	s1.top(); 
    	s1.pop(); 
    	s1.isEmpty(); 
    	s1.top(); 
    	s1.pop(); 
    	s1.isEmpty();
    	
    	
    }
}
