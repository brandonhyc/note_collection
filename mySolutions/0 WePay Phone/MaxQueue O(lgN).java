// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        MaxQueue maxQ = new MaxQueue();
        maxQ.offer(5);
        maxQ.offer(3);
        maxQ.offer(4);
        maxQ.offer(9);
        maxQ.offer(25);
        maxQ.offer(1);
        maxQ.offer(0);
        System.out.println(maxQ.pollMax());
        System.out.println(maxQ.poll());
        System.out.println(maxQ.poll());
        System.out.println(maxQ.pollMax());
        System.out.println(maxQ.poll());
        System.out.println(maxQ.poll());
        System.out.println(maxQ.poll());
    }
}


class MaxQueue {
    // implement poll, offer, pollMax
    // all ops - time complexity: O(lgn)
    Map<Integer, Node> map; 
    Node head;
    Node tail;
    public MaxQueue() {
        map = new TreeMap<>((a,b) -> b - a);
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    int pollMax() {
        Map.Entry<Integer, Node> en = map.entrySet().iterator().next();
        map.remove(en.getKey());
        Node curr = en.getValue();
        int maxVal = en.getKey();
        
        Node prev = curr.prev;
        Node next = curr.next;
        prev.next = next;
        next.prev = prev;
        
        return maxVal;
    }
    
    void offer(int value) {
        Node curr = new Node(value);
        Node prev = tail.prev;
        prev.next = curr;
        tail.prev = curr;
        curr.next = tail;
        curr.prev = prev;
        
        map.put(value, curr);
    }
    
    int poll() {
        int value = head.next.val;
        Node temp = head.next.next;
        head.next = temp;
        temp.prev = head;
        
        map.remove(value);
        return value;
    }
    
}

class Node{ // doublelinkedlist
    int val;
    Node next;
    Node prev;
    
    Node(int value) {
        this.val = value;    
    }
    
}