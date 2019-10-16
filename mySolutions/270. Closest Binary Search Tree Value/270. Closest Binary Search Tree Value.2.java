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
        
        TreeNode closetNode = null;
        
        while (root != null) {
            if (closetNode == null
                || Math.abs(closetNode.val - target) > Math.abs(root.val - target)) {
                closetNode = root;
            }
            
            root = target < root.val ? root.left : root.right;
            
        }
        
        
        return closetNode == null ? -1 : closetNode.val;
    }
}