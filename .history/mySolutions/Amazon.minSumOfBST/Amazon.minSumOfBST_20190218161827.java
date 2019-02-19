public class Solution {
    int minSum = Integer.MAX_VALUE;
    public int PathSum(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return getMinPathSum(root, 0);
    }

    private int getMinPathSum(TreeNode root, int sum) {
        sum = sum + root.val;

        if (root.left == null && root.right == null) {
            this.minSum = Math.min(minSum, sum);
        }
        if (root.left != null) {
            getMinPathSum(root.left, sum);
        }
        if (root.right != null) {
            getMinPathSum(root.right, sum);
        }
        
        return 
    }
}