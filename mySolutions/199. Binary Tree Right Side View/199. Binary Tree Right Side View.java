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
    public List<Integer> rightSideView(TreeNode root) {
        
        if (root == null) {
            return new ArrayList<>();
        }
        
        List<Integer> result = new ArrayList<>();
        preorderFromRight(result, root, 1);
        
        return result;
    }
    
    private void preorderFromRight(List<Integer> result, TreeNode root, int depth) {
        
        if (root == null) {
            return;
        }
        if (result.size() < depth) {
            result.add(root.val);
        }
        
        preorderFromRight(result, root.right, depth + 1);
        preorderFromRight(result, root.left, depth + 1);
        
        
        return;
    }
}