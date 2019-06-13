/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else if (key == root.val) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            TreeNode successor = getSuccessor(root);

            deleteNode(root, successor.val);
            root.val = successor.val;

            return root;
        }
        return root;
    }

    private TreeNode getSuccessor(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode pre = root;
        TreeNode node = root.right;
        while (node != null) {
            pre = node;
            node = node.left;
        }
        return pre;
    }
}
