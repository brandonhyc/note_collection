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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> levels = new LinkedList<>();
        levelOrderTraversalAsc(root, levels, -1);
        return levels;
    }    
    
    private void levelOrderTraversalAsc(TreeNode root, LinkedList<List<Integer>> levels, int depth) {
        if (root == null) { // the bottom
            return;
        }
        
        int currentDepth = depth + 1;
        if (levels.size() <= currentDepth) {
            levels.addFirst(new ArrayList<>());
        }
        
        levelOrderTraversalAsc(root.left, levels, currentDepth);
        levelOrderTraversalAsc(root.right, levels, currentDepth);
        
        
        int totalHeight = levels.size();
        List<Integer> level = levels.get(totalHeight - 1 - currentDepth);
        level.add(root.val);
    }
}