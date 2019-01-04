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

        return divConq(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean divConq(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        //if (root != null)
        if (root.val <= min || root.val >= max) {
            return false;
        }
    }
}