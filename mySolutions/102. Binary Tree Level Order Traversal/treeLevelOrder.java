/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here

        if (root == null) {
            return null;
        }

        List<List<Integer>> results = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            ArrayList<Integer> levelOrder = new ArrayList<>();
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();
                levelOrder.add(node.val);

                if (node != null && node.left != null) {
                    queue.offer(node.left);
                }
                if (node != null && node.right != null) {
                    queue.offer(node.right);
                }
                
            }
            results.add(levelOrder);
        }
        return results;


    }
}