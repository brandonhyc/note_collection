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
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        traversal(root, list);

        return;
    }
    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
    }
}