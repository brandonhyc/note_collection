class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> queue;
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(x);
        while (!queue.isEmpty()) {
            que.offer(queue.poll());
        }
        queue = que;
        // System.out.printf("queue: %s", queue.toString());
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int a = queue.poll();
        // System.out.printf("queue: %s", queue.toString());
        return a;
    }
    
    /** Get the top element. */
    public int top() {
        int a = queue.peek();
        // System.out.printf("queue: %s", queue.toString());
        return a;
    }
    /** Returns whether the stack is empty. */
    public boolean empty() {
        // System.out.printf("queue: %s", queue.toString());
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */