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
    public boolean isBalanced(TreeNode root) {
        
        return dfs(root) != -1;
    }
    
    private int dfs(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        int leftHi = dfs(root.left);
        int rightHi = dfs(root.right);
        
        if (leftHi == -1 || rightHi == -1) {
            return -1;
        }
        if (Math.abs(leftHi - rightHi) > 1) {
            return -1;
        }
        
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }
}