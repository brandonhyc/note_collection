/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {

        Queue<Node> queue = new LinkedList<>();
        Node prev = null;
        
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node cur = queue.poll();

                if (cur == null) {
                    continue;
                }
                if (prev != null) {
                    prev.next = cur; 
                }
                
                queue.offer(cur.left);
                queue.offer(cur.right);
                prev = cur;
                
            }
            prev = null;
        }
        return root;
    }   
}