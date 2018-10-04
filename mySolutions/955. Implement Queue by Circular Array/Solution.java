public class CircularQueue {

    int[] circularArray;
    int front;
    int rear;
    int size;

    public CircularQueue(int n) {
        // initialize your data structure here
        circularArray = new int[n];
        front = 0;
        rear = 0;
        size = 0;
    }

    /**
     * @return: return true if the array is full
     */
    public boolean isFull() {
        // write your code here
        return size == circularArray.length;
    }

    /**
     * @return: return true if there is no element in the array
     */
    public boolean isEmpty() {
        // write your code here
        return size == 0;
    }

    /**
     * @param element: the element given to be added
     * @return: nothing
     */
    public void enqueue(int element) {
        // write your code here
        if (isFull()) return;

        circularArray[rear] = element;
        rear = (rear + 1) % circularArray.length;
        size++;
        return;
    }

    /**
     * @return: pop an element from the queue
     */
    public int dequeue() {
        // write your code here

        if (isEmpty()) return -1;
        
        int result = circularArray[front]; 
        front = (front + 1) % circularArray.length;
        size--;

        return result;
    }
}