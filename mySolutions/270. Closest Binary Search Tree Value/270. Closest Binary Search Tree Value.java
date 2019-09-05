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
    
    public int closestValue(TreeNode root, double target) {
        int cloest = -1;
        
        if (root == null) {
            return cloest;
        }
        
        TreeNode cur = root;
        
        while (cur != null) {
            
            if (Math.abs(cur.val - target) < Math.abs(cloest - target) || cloest == -1) {
                cloest = cur.val;
            }
            
            cur = (target < cur.val) ? cur.left : cur.right;
        }
        
        return cloest;
    }
    
}