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
        
        if (root.left == null && root.right == null) {
            return null;
        }
        
        int left = Math.min(p.val, q.val);
        int right = Math.max(p.val, q.val);
        
        if (root.val == left || root.val == right) {
            return root;
        }
        
        if (left < root.val && root.val < right) {
            return root;
        }
        
        if (left < root.val && right < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (left > root.val && right > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }
}