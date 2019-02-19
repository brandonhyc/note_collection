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
        List<Integer> result = new ArrayList<>();

        search(results, result, root, sum);
        return results;
    }
    private void search(List<List<Integer>>) {
        return;
    }
}