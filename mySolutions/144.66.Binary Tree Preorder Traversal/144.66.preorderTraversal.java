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
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();

        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
           return; 
        }
        if (root != null) {
            result.add(root.val);
            preorder(root.left, result);
            preorder(root.right, result);
        }
        return;
    }
}