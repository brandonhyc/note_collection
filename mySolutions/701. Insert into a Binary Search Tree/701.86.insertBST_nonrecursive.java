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
    /*
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode target) {
        // write your code here
        if (root == null) {
            return target;
        }

        TreeNode parent = root;
        TreeNode child = root;

        while (child != null) {
            parent = child;

            if (target.val <= parent.val) {
                // on the left
                child = parent.left;
            } else {
                // on the right
                child = parent.right;
            }
        }
        
        if (target.val <= parent.val) {
            parent.left = target;
        } else {
            parent.right = target;
        }

        return root;
    }
}