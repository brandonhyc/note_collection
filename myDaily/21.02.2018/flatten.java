public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    //20.02.2018
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
    
        //divide and conquer
        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);
    
        //merge
        if (leftLast != null) {
            leftLast.right = root.right;    
            root.right = root.left;
            root.left = null;
        }
    
        if (rightLast != null) {
            return rightLast;
        }
    
        if (leftLast != null) {
            return leftLast;
        }
        
        return root;
    }
}