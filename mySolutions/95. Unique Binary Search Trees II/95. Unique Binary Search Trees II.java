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
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        
        return genTree(1, n);
    }
    
    private List<TreeNode> genTree(int start, int end) {
        
        List<TreeNode> list = new ArrayList<>();
        
        if (start > end) {
            list.add(null);
            return list;
        }
        
        if (start == end) {
            list.add(new TreeNode(start));
            
            return list;
        }
        
        for (int i = start; i <= end; i++) {
            
            List<TreeNode> leftTrees = genTree(start, i - 1);
            List<TreeNode> rightTrees = genTree(i + 1, end);
            
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree: rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    
                    list.add(root);
                }
            }
            
        }
        
        return list;
            
    }
    
}