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
    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> results = new ArrayList<>();
        
        height(results, root);
        
        return results;
    }
    
    private int height(List<List<Integer>> results, TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        int realHeight = Math.max(height(results, root.left), height(results, root.right));
        
        if (results.size() < realHeight + 1) {
            results.add(new ArrayList<>());
        }
        List<Integer> leaves = results.get(realHeight);
        leaves.add(root.val);
        
        return realHeight + 1;
        
        
    }
}