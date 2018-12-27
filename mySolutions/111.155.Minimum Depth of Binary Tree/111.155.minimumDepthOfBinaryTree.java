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
     * @param root: The root of binary tree
     * @return: An integer
     */
    public int minDepth(TreeNode root) {
        // write your code here

        if (root == null) {
            return 0;
        }

        return getMin(root);
    }
    
    private int getMin(TreeNode node) {
        int minDepth = 0;

        if (node == null) {
            minDepth = Integer.MAX_VALUE;
        }

        if (node != null) {
            minDepth = 1;
            if (node.left == null && node.right == null) {
                minDepth = minDepth;
            } else {
                int left = getMin(node.left);
                int right = getMin(node.right);

                minDepth = minDepth + Math.min(left, right);
            }
        }
        return minDepth; 
    }
}