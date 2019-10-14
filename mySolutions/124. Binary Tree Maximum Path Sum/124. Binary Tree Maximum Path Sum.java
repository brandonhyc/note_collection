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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return max;
    }
    
    private int getMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftMax = getMaxPathSum(root.left);        
        int rightMax = getMaxPathSum(root.right);
        
        max = Math.max(root.val + leftMax + rightMax, max);
        int sum = Math.max(root.val + leftMax, root.val + rightMax);
        
        // System.out.printf("root.val: %d, leftMax: %d, rightMax: %d, sum: %d, max: %d\n", root.val, leftMax, rightMax, sum, max);
        return Math.max(0, sum);
    }
}