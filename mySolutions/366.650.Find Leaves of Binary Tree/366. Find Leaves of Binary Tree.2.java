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
        List<List<Integer>> results = new ArrayList<>();
        getLeaves(root, results);
        return results;
    }
    
    private void getLeaves(TreeNode root, List<List<Integer>> levels) {
        if (root == null) {
            return;
        }
        
        getLeaves(root.left, levels);
        getLeaves(root.right, levels);
        
        int currentHi = getHeight(root);
        if (levels.size() <= currentHi) {
            levels.add(new ArrayList<>());
        }
        List<Integer> currentLevel = levels.get(currentHi); 
        currentLevel.add(root.val);
        
    }
    
    
    private int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}