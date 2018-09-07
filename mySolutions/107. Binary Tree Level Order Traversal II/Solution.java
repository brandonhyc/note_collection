/**
 * Definition for a binary tree node.
 * 
 * public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int
 * x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> layer = new ArrayList<>();
            list.add(layer);
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                layer.add(node.val);
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
        }
        Collections.reverse(list);
        return list;
    }
}