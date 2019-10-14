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
        List<List<Integer>> levels = new ArrayList<>();
        
        boolean leftToRight = false;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            leftToRight ^= true; 
            
            LinkedList<Integer> level = new LinkedList<>();
            levels.add(level);
            
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                
                if (leftToRight) {
                    level.add(root.val);
                } 
                else {
                    level.addFirst(root.val);    
                }
                
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
                
            }
            
        }
        
        
        return levels;
    }
}