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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        dfs(root, result, 0);
        
        return result;
    }
    
    private void dfs(TreeNode node, List<List<Integer>> result, int level) {
        
        if (node == null) {
            return;
        }
        
        if (result.size() <= level) {
            result.add(new LinkedList<>());
        }

        LinkedList<Integer> levelList = (LinkedList<Integer>) result.get(level);
        if (level % 2 == 0) levelList.add(node.val); 
        else levelList.push(node.val);

        // System.out.printf("At level: %d ,", level);
        // System.out.println(Arrays.toString(levelList.toArray()));
        dfs(node.left, result, level + 1);
        dfs(node.right, result, level + 1);
    }
}