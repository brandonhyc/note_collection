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
        List<List<Integer>> results, 
        int sum, List<Integer> path, TreeNode root) {
        
        if (root == null) {
            return;
        }

        // if (root != null)
        path.add(root);
        sum = sum - root.val;
        if (root.left == null && root.right == null
            && sum == 0) {
            results.add(new ArrayList<Integer>(path));
        }
        
        search(results, sum, path, root.left);
        search(results, sum, path, root.right);

        path.remove(path.size() - 1);
    }
}