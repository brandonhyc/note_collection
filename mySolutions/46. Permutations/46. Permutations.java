class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> results = new ArrayList<>();
        dfs(nums, results, new ArrayList<>());
        return results;
    }
    
    private void dfs(int[] nums, List<List<Integer>> results, List<Integer> permutation) {
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<>(permutation));
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (permutation.contains(nums[i])) {
                continue;
            }
            permutation.add(nums[i]);
            dfs(nums, results, permutation);
            permutation.remove(permutation.size() - 1);
        }
        
        return;
    }
}