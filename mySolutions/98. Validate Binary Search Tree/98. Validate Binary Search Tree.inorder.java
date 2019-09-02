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
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        boolean result = true;
        TreeNode pre = null;
        
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();
            
            if (pre != null) {
                result = result && pre.val < cur.val;
            }
            pre = cur;
            
            cur = cur.right;
        }
        
        return result;
    }
    
}