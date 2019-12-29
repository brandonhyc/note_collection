/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        
        dfs(head);

        return head;
    }

    private Node dfs(Node root) {
        Node cur = root;
        Node pre = new Node();
        pre.next = cur;
        
        while (cur != null) {
            if (cur.child != null) {
                Node curNext = cur.next;
                cur.next = cur.child;
                cur.next.prev = cur;        
                Node curChildTail = dfs(cur.child);
                cur.child = null;
                curChildTail.next = curNext;
                
                // for endings
                if (curNext != null) {
                    curNext.prev = curChildTail;
                }
            }
            
            cur = cur.next;
            pre = pre.next;
        }
        
        return pre;
    }
}