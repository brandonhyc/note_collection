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
        return (hasPathSum(node.left, sum - node.val)
            || hasPathSum(node.right, sum - node.val));
    }
}