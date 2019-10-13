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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        sum -= root.val;
        
        if (sum == 0 && root.left == null && root.right == null) {
            List<List<Integer>> results = new ArrayList<>();
            List<Integer> result = new LinkedList<>();
            result.add(root.val);
            results.add(result);
            return results;
        }
        
        List<List<Integer>> leftPaths = pathSum(root.left, sum);
        List<List<Integer>> rightPaths = pathSum(root.right, sum);
        leftPaths.addAll(rightPaths);
        
        for (List<Integer> path: leftPaths) {
            ((LinkedList<Integer>) path).addFirst(root.val);
        }
        
        return leftPaths;
        
        
    }
    
}