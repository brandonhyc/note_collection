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
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            results.add(path);
            return results;
        }

        List<Integer> path = new ArrayList<>();
        search(results, path, root, sum);
        return results;
    }
    private void search(
        List<List<Integer>> results, 
        List<Integer> path, 
        TreeNode root, 
        int sum) {

        if (root == null) {
            return;
        }
        if (root.left == null 
            && root.right == null 
            && sum == 0) {
            results.add(new ArrayList<>(path));
            return;
        }
        sum = sum - root.val;
        path.add(root);

        search(result, path, root.left, sum);
        search(result, path, root.right, sum);
        path.remove(path.size() - 1);

        return;
    }
}