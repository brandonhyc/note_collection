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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        return findNode(root, p, q);
    }
    
    private TreeNode findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        TreeNode foundInLeft = findNode(root.left, p, q);
        TreeNode foundInRight = findNode(root.right, p, q);
        
        if (root == p || root == q) {
            return root;
        }
        
        if (foundInLeft != null && foundInRight != null) {
            return root;
        }
        else if (foundInLeft != null) {
            return foundInLeft;
        }
        else if (foundInRight != null) {
            return foundInRight;
        }
        
        return null;
    }
}