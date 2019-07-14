/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        
        if (head == null) {
            return null;
        }
        
        Map<Node, Node> map = new HashMap<>();
        Node node = head;
        
        while (node != null) {
            
            if (!map.containsKey(node)) {
                map.put(node, new Node());
            }
            if (node.next != null && !map.containsKey(node.next)) {
                map.put(node.next, new Node());
            }
            if (node.random != null && !map.containsKey(node.random)) {
                map.put(node.random, new Node());
            }
            Node clone = map.get(node);
            
            clone.val = node.val;
            clone.next = map.get(node.next);
            clone.random = map.get(node.random);
            
            node = node.next;
        }
        
        return map.get(head);
    }
}