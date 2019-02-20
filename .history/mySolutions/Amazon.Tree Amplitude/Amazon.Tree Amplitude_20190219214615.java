class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x) {
        val = x;
        left = null;
        right = null;
    }
}
public class Solution {
    /**
     */
    public int TreeAmplitude(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return search(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private int search(
            TreeNode root, int max, int min) {

    }
}