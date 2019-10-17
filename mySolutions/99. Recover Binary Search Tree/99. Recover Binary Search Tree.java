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
    public void recoverTree(TreeNode root) {
     
        TreeNode firstDefeat = null;
        TreeNode secondDefeat = null;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        
        while (root != null || !stack.isEmpty()) {
            
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            
            if (pre != null && pre.val > root.val) {
                if (firstDefeat == null) {
                    firstDefeat = pre;
                }
                secondDefeat = root;
            }            
            
            pre = root;
            root = root.right;
        }
        
        int temp = firstDefeat.val;
        firstDefeat.val = secondDefeat.val;
        secondDefeat.val = temp; 
    }
}