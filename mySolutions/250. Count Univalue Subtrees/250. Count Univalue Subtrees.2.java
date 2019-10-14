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
    
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        
        isUnivalSubtree(root);
        return count;
    }
    
    private boolean isUnivalSubtree(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (root.left == null && root.right == null) {
            count++;
            return true;
        }
        // 1. all subtree needs to be unival
        boolean isUnivalTree = true;
        isUnivalTree = isUnivalSubtree(root.left) && isUnivalTree;
        isUnivalTree = isUnivalSubtree(root.right) && isUnivalTree;
        
        // 2. check if this whole tree is a unival 
        if (root.left != null) {
            isUnivalTree = isUnivalTree && root.left.val == root.val;
        }
        if (root.right != null) {
            isUnivalTree = isUnivalTree && root.right.val == root.val;
        }
        if (isUnivalTree) {
            count++;
        }
        
        return isUnivalTree;
    }
}