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
    public boolean hasPathSum(TreeNode root, int sum) {
        // System.out.printf("root.val: %d, sum: %d\n", root.val, sum);
        
        if (root == null) {
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        
        sum = sum - root.val;
        
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        
    }

}