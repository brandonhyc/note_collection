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
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) {
            results.add(path);
            return results;
        }

        search(results, path, root, sum);
        return results;
    }
    private void search(
        List<List<Integer>> results, 
        List<Integer> path, 
        TreeNode root, 
        int sum) {

//         1 
//     2       3
// 4       5 6   7
        if (root == null) {
            return;
        }
        int sum = 0;

        if (root.left == null 
            && root.right == null 
            && sum == 0) {
            results.add(new ArrayList<>(path));
            return;
        }
        sum = sum - root.val;
        path.add(root.val);

        search(results, path, root.left, sum);
        search(results, path, root.right, sum);
        path.remove(path.size() - 1);

        return;
    }
}