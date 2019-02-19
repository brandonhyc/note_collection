public class Solution {
    int minSum = Integer.MAX_VALUE;
    public int PathSum(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return getPathSum(root, 0);
    }

    private int getPathSum(TreeNode root, int sum) {
        
    }
}