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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null || root.left.val != root.right.val) {
            return false;
        }
        
        Queue<TreeNode> leftStack = new LinkedList<>();
        Queue<TreeNode> rightStack = new LinkedList<>();
        
        leftStack.offer(root.left);
        rightStack.offer(root.right);
        
        while (!leftStack.isEmpty() || !rightStack.isEmpty()) {
            int size = leftStack.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode leftRoot = leftStack.poll();
                TreeNode rightRoot = rightStack.poll();
                
                if (leftRoot.left != null && rightRoot.right != null) {
                    if (leftRoot.left.val != rightRoot.right.val) {
                        return false;
                    }
                    leftStack.offer(leftRoot.left);
                    rightStack.offer(rightRoot.right);
                }
                else if (leftRoot.left == null && rightRoot.right == null ) {
                    // do nothing
                }
                else if (leftRoot.left == null || rightRoot.right == null) {
                    return false;
                }
                
                if (leftRoot.right != null && rightRoot.left != null) {
                    if (leftRoot.right.val != rightRoot.left.val) {
                        return false;
                    }
                    leftStack.offer(leftRoot.right);
                    rightStack.offer(rightRoot.left);
                }
                else if (leftRoot.right == null && rightRoot.left == null ) {
                    // do nothing
                }
                else if (leftRoot.right == null || rightRoot.left == null) {
                    return false;
                }
            }
            
        }
        
        return true;
    }
}