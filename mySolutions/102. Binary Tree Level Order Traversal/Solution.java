
/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here

        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);

        while (!que.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = que.size();

            for (int i = 0; i < size; i++) {
                TreeNode tree = que.poll();
                level.add(tree.val);
                if (tree.left != null) {
                    que.offer(tree.left);
                }
                if (tree.right != null) {
                    que.offer(tree.right);
                }
            }
            res.add(level);
        }

        return res;
    }
}