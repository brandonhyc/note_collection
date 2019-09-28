class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> mins;
    int min;
    
    public MinStack() {
        stack = new Stack<>();
        mins = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        stack.push(x);
        if (mins.isEmpty() || mins.peek() >= x) {
            mins.push(x);
        }
    }
    
    public void pop() {
        int x = stack.pop();
        if (mins.peek() == x) {
            mins.pop();
        }
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */