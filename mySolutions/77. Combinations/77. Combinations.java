class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> results = new ArrayList<>();
        dfs(n, k, results, new ArrayList<>(), 1);
        
        return results; 
    }
    
    private void dfs(int n, int k, List<List<Integer>> results, List<Integer> combination, int start) {
        
        if (k == 0) {
            results.add(new ArrayList<>(combination));
            return;
        }
        if (start >= n + 1) {
            return;
        }
        // if pick
        combination.add(start);
        dfs(n, k - 1, results, combination, start + 1);
        combination.remove(combination.size() - 1);
        
        // if not pick
        dfs(n, k, results, combination, start + 1);
    }
}