class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> results = new ArrayList<>();
        
        dfs(nums, results, new ArrayList<>(), 0);
        
        return results;
    }
    
    
    private void dfs(int[] nums, List<List<Integer>> results, List<Integer> subset, int start) {
        results.add(new ArrayList<>(subset));
        
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, results, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
        
        return;
    }
}