public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */

    public Queue<Integer> queue1 = new LinkedList<>();
    public Queue<Integer> queue2 = new LinkedList<>();

    public void push(int x) {
        // write your code here
        queue1.add(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        if (queue1.isEmpty()) return;
        int temp;
        while (queue1.size() != 1) {
            temp = queue1.poll();
            queue2.offer(temp);
        }
        
        queue1.poll();
        queue1 = queue2;
        queue2 = new LinkedList<Integer>();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        int temp = -1;
        if (queue1.isEmpty()) return temp;
        while (queue1.size() != 0) {
            temp = queue1.poll();
            queue2.offer(temp);
        }
        queue1 = queue2;
        queue2 = new LinkedList<Integer>();
        return temp;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return queue1.size() == 0;
    }
}