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
    int max = 1;
    
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        searchLongestConsecutive(root);
        return max;
    }
    
    private int searchLongestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftLongest = 1 + searchLongestConsecutive(root.left);
        if (root.left == null || root.left.val != root.val + 1) {
            leftLongest = 1;
        }
        
        int rightLongest = 1 + searchLongestConsecutive(root.right);
        if (root.right == null || root.right.val != root.val + 1) {
            rightLongest = 1;
        }
        
        int localMax = Math.max(leftLongest, rightLongest);
        max = Math.max(localMax, max);
        
        return localMax;
    }
}