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
        
        Queue<TreeNode> que  = new LinkedList<>();
        boolean isEvenLevel = false;
        
        que.offer(root);
        while (!que.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int count = que.size();
            
            for (int i = 0; i < count; i++) {
                TreeNode node = que.poll();

                level.add(node.val);
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            if (isEvenLevel) {
                Collections.reverse(level);
            }
            isEvenLevel = !isEvenLevel;
            result.add(level);
            
        }
        
        return result;
    }
}