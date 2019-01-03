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
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            return node;
        }
        insert(node, root);

        return root;
    }

    private void insert(TreeNode node, TreeNode root) {
        if (node.val <= root.val) {
            // on the left
            
            if (root.left == null) {
                // empty node
                root.left = node;
                return;
            }
            insert(node, root.left);
        } else {
            // on the right
            
            if (root.right == null) {
                //empty node
                root.right = node;
                return;
            }
            insert(node, root.right);
        }

        return;
    }
}