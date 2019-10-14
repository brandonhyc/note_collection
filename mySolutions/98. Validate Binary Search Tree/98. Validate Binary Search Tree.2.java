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
    TreeNode pre = null;
    boolean allSubtreeIsValid = true;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        inorder(root);
        
        return allSubtreeIsValid;
    }
    
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        
        if (pre != null && root.val <= pre.val) {
            allSubtreeIsValid = false;
        }
        pre = root;
        
        inorder(root.right);
        
        return;
    }
}