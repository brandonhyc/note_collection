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

        Collections.sort(list);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < (list.size() - 1); i++) {
            min = Math.min((list.get(i) - list.get(i + 1)), min);
        }
        return;
    }
    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        traversal(root.left);
        traversal(root.right);
    }
}