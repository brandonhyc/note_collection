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
    // 坐标是啥
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<TreeNode, Integer>(root, 0));
        int maxWidth = 0;
        while (queue.size() != 0) {
            int size = queue.size();
            Integer l = null, r = null;
            // System.out.printf("size: %d\n", size);
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode curr = pair.getKey();
                int col = pair.getValue();
                if (l == null || col < l) l = col; 
                if (r == null || col > r) r = col;
                // System.out.printf("l: %d, r: %d, col: %d\n", l, r, col);
                
                if (curr.left != null) queue.offer(new Pair<>(curr.left, 2 * col));
                if (curr.right != null) queue.offer(new Pair<>(curr.right, 2 * col + 1));
            }
            
            maxWidth = Math.max(r - l + 1, maxWidth);
            
        }
        
        return maxWidth;
    }
}