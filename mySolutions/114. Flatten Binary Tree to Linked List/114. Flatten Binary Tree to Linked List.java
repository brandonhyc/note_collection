/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public void flatten(TreeNode root) {

        postorder(root, null);
    }

    private TreeNode postorder(TreeNode root, TreeNode pre) {
        if (root == null) {
            return pre;
        }
        pre = postorder(root.right, pre);
        pre = postorder(root.left, pre);

        root.right = pre;
        root.left = null;

        return root;
    }
}