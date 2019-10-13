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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> results = new ArrayList<>();
        
        while (root != null || !stack.isEmpty()) {
            
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            results.add(root.val);
            root = root.right;
            
        }
        
        return results;
    }
}