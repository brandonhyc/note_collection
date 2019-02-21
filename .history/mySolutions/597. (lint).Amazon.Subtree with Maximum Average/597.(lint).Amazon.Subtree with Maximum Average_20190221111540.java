/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    class ResultType {
        TreeNode node;
        int sum;
        int size;

        public ResultType(TreeNode node, int sum, int size) {
            this.node = node;
            this.sum = sum;
            this.size = size;
        }
    }

    private ResultType result = null;
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        ResultType rootResult = calTreeAverge(root);

        return result.node;
    }

    private ResultType calTreeAverge(TreeNode root) {
        if (root == null) {
            return new ResultType(null, 0, 0); // here is a zero
        }
        ResultType left = calTreeAverge(root.left);
        ResultType right = calTreeAverge(root.right);
        ResultType result = new ResultType(
            root,
            left.sum + right.sum + root.val,
            left.size + right.size + 1
        );

        if () {

        }

        return result;
    }

}