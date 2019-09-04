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
    
    
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        List<String> results = new ArrayList<>();
        inorder(results, "" + root.val, root);    
        
        return results;
    }
    
    private void inorder(List<String> results, String prefix, TreeNode root) {
    
        if (root.left == null && root.right == null) {
            results.add(new String(prefix));
            return;
        }
        
        if (root.left != null) {
            inorder(results, prefix + "->" + root.left.val, root.left);
        }
        if (root.right != null) {
            inorder(results, prefix + "->" + root.right.val, root.right);
        }
    }
}