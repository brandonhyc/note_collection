/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    private TreeNode lastNode;
    private boolean isValid;

    public boolean isValidBST(TreeNode root) {
        // write your code here
        lastNode = null;
        isValid = true;
        inorderTraverse(root);

        return isValid;
    }

    private void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root != null) {
            inorderTraverse(root.left);

            if (lastNode != null && 
                lastNode.val >= root.val) {
                isValid = false;
                return;
            }
            lastNode = root;
            inorderTraverse(root.right);
        }
    }
}