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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (node == null) {
            return sum == 0;
        }
        return (sumOf(node.left, sum - node.val)
            || sumOf(node.right, sum - node.val));
    }

    
}