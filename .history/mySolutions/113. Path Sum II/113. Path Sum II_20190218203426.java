class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) {
            results.add(path);
            return results;
        }

        search(results, target, path, root);
        return results;
    }

    private void search(
        List<List<Integer>>results, 
        int target, List<Integer>path, TreeNode root) {

    }
}