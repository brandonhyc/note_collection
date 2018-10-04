public class MyQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public MyQueue() {
        // do intialization if necessary
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if (stack1.empty()) return -1;

        reverseStack1();
        int head = stack1.pop();
        reverseStack1();

        return head;
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if (stack1.empty()) return -1;
        int next = reverseStack1();
        reverseStack1();
        return next;
    }

    private int reverseStack1() {
        int next = -1;
        while (!stack1.empty()) {
            next = stack1.pop();
            stack2.push(next);
        }

        stack1 = stack2;
        stack2 = new Stack<>();

        return next;
    }
}