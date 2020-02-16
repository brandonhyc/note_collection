/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node curr = head;
        Map<Node, Node> map = new HashMap<>();
        map.put(curr, new Node(curr.val));
        
        while (curr != null) {
            Node next = curr.next;
            Node rand = curr.random;
            
            if (next != null && !map.containsKey(next)) {
                map.put(next, new Node(next.val));
            }
            if (rand != null && !map.containsKey(rand)) {
                map.put(rand, new Node(rand.val));
            }
            map.get(curr).next = map.getOrDefault(next, null);
            map.get(curr).random = map.getOrDefault(rand, null);
            
            curr = curr.next;
        }
        
        return map.get(head);
    }
}