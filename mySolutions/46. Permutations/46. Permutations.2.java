class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> results = new ArrayList<>();
        dfs(nums, results, new ArrayList<>(), new HashSet<>());
        return results;
    }
    
    private void dfs(int[] nums, List<List<Integer>> results, List<Integer> permutation, Set<Integer> visited) {
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<>(permutation));
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(nums[i])) {
                continue;
            }
            visited.add(nums[i]);
            permutation.add(nums[i]);
            dfs(nums, results, permutation, visited);
            permutation.remove(permutation.size() - 1);
            visited.remove(nums[i]);
        }
        
        return;
    }
}