/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        Node dummy = new Node();
        Node pre = inorder(root, dummy);

        pre.right = dummy.right;
        dummy.right.left = pre;

        return dummy.right;
    }

    private Node inorder(Node root, Node pre) {
        if (root == null) {
            return pre;
        }

        pre = inorder(root.left, pre);
        pre.right = root;
        root.left = pre;
        pre = inorder(root.right, root);

        return pre;
    }

}