class MinStack {

    /** initialize your data structure here. */
    
    Stack<Integer> st = new Stack<>();
    Stack<Integer> minSt = new Stack<>();
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int x) {
        st.add(x);
        if (minSt.size() == 0 || minSt.peek() >= x) {
            minSt.push(x);
        }
    }
    
    public void pop() {
        int val = st.pop();
        if (val == minSt.peek()) {
            minSt.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
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