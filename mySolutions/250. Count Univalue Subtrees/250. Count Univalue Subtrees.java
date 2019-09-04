/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return count;
        }

        isUnivalueSubtree(root);

        return count;
    }

    private boolean isUnivalueSubtree(TreeNode root) {

        if (root == null) {
            return true;
        }

        boolean leftIsUnival = isUnivalueSubtree(root.left);
        boolean rightIsUnival = isUnivalueSubtree(root.right);

        if (leftIsUnival && rightIsUnival && (root.left == null || root.left.val == root.val)
                && (root.right == null || root.right.val == root.val)) {

            count++;
            return true;
        }

        return false;
    }

}