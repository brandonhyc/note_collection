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
    /*
     * @param root: the root of binary tree
     * @return: collect and remove all leaves
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        // write your code here
        if (root == null) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> result = new ArrayList<>();
        getDepth(root, result);
        return result;
    }

    private int getDepth(TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return 0;
        }
        
        int left = getDepth(root.left, result);
        int right = getDepth(root.right, result);
        int index = Math.max(left, right);

        if (result.size() <= index) {
            result.add(new ArrayList<>());
        }
        result.get(index).add(root.val);
        return index + 1;
    }
}