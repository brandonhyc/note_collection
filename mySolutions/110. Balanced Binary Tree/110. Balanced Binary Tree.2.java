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
        if (root == null) {
            return true;
        }
        if (!isBalanced(root.left)) {
            return false;
        }
        if (!isBalanced(root.right)) {
            return false;
        }
        
        return Math.abs(countHi(root.left) - countHi(root.right)) <= 1;
    }
    
    private int countHi(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return Math.max(countHi(root.left), countHi(root.right)) + 1;  
    }
}