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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        boolean result = true;
        
        if (root.left != null) {
            
            result = result 
                && root.left.val < root.val 
                && isValidBST(root.left) 
                && getPredecessor(root).val < root.val;
        }
        
        if (root.right != null) {
            result = result
                && root.val < root.right.val
                && isValidBST(root.right)
                && root.val < getSuccessor(root).val;
        }
        
        return result;
    }
    
    private TreeNode getSuccessor(TreeNode root) {
        if (root == null || root.right == null) {
            return root;
        }
        
        root = root.right;
        
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    
    private TreeNode getPredecessor(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        
        root = root.left;
        
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}