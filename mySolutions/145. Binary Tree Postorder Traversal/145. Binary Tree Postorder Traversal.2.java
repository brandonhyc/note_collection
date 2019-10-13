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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> results = new LinkedList<>();
        
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                results.addFirst(root.val);
                stack.push(root);
                root = root.right;
            }   
            root = stack.pop();
            root = root.left;
        }
        return results;
    }
}