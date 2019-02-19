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
        int target, 
        List<Integer> path, 
        TreeNode root) {

//         1 
//     2       3
// 4       5 6   7
        if (root == null) {
            return;
        }

        // exit 
        // if (root != null) 
        path.add(root.val);
        int sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum = sum + path.get(i);
            if (sum == target) {
                List<Integer> subList = path.subList(i, path.size()); 
                results.add(new ArrayList<Integer>(subList));
            }
        }

        search(results, target, path, root.left);
        search(results, target, path, root.right);
        path.remove(path.size() - 1);

        return;
    }
}