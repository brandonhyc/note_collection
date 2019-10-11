class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        if (candidates.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> results = new ArrayList<>();
        
        dfs(candidates, target, results, new ArrayList<>(), 0, 0);
        
        return results;
    }
    
    private void dfs(int[] candidates, int target, List<List<Integer>> results, List<Integer> list, int sum, int start) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            results.add(new ArrayList<>(list));
        }
        
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(candidates, target, results, list, sum + candidates[i], i);    
            list.remove(list.size() - 1);
        }
        return;
    }
}