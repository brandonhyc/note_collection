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
        List<Integer> result = new ArrayList<>();
        preorderRightToLeft(root, result, 0);
        return result;
    }
    
    private void preorderRightToLeft(TreeNode root, List<Integer> order, int depth) {
        if (root == null) {
            return;
        }
        
        if (order.size() <= depth) {
            order.add(root.val);
        }
        
        preorderRightToLeft(root.right, order, depth + 1);
        preorderRightToLeft(root.left, order, depth + 1);
        
    }
}