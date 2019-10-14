/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMinDepth(root, 0);
        return min;
    }
    
    private void getMinDepth(TreeNode root, int distance) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            min = Math.min(distance + 1, min);
            return;
        }
        if (root.left != null) {
            getMinDepth(root.left, distance + 1);
        }
        if (root.right != null) {
            getMinDepth(root.right, distance + 1);
        }
        
    }
}