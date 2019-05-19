class MinStack {

    int minValue;
    LinkedList<Integer> list;
    
    /** initialize your data structure here. */
    public MinStack() {
        minValue = Integer.MAX_VALUE; 
        list = new LinkedList<>();
    }
    
    public void push(int x) {
        list.add(x);
        minValue = Math.min(x, minValue);
    }
    
    public void pop() {
        if (list.size() == 0) {
            return;
        }
        int last = list.removeLast();
        
        if (last != minValue) {
            minValue = minValue;      
        }
        else if (last == minValue) {
            minValue = Integer.MAX_VALUE;
            for (int i = 0; i < list.size(); i++) {
                minValue = Math.min(minValue, list.get(i));
            }
        }
    }
    
    public int top() {
        return list.getLast() != null ?  list.getLast() : -1;
    }
    
    public int getMin() {
        return minValue;
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