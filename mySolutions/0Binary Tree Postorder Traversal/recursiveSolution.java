/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here

        if (root == null) {
            return null;
        }
        
        List<Integer> list = new ArrayList<>();
        divideAndConquer(list, root);
        return list;
    }
    private void divideAndConquer(List list, TreeNode root) {
        if (root == null) {
            return;
        }
        divideAndConquer(list, root.left);
        divideAndConquer(list, root.right);
        list.add(root.val);
    }
}