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
    
    int total = 0;
    
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return total;
        }
        
        inorder(0, root);
        
        
        return total;
        
    }
    
    private void inorder(int adder, TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            total = total + adder * 10 + root.val;
            return;
        }
        
        inorder(adder * 10 + root.val, root.left);
        inorder(adder * 10 + root.val, root.right);
    }
}