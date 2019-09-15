class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        if (candidates.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> results = new ArrayList<>();
        
        dfs(candidates, target, results, 0, new ArrayList<>(), 0);
        
        return results;
    }
    
    private void dfs(int[] candidates, int target, List<List<Integer>> results, int sum, List<Integer> sumList, int start) {
        if (sum > target) {
            return;
        }
        
        if (sum == target) {
            results.add(new ArrayList<>(sumList));
            return;
        }
        
        // add candidate start, sum += can, sumList.add(can)
        sumList.add(candidates[start]);
        dfs(candidates, target, results, sum + candidates[start], sumList, start);
        sumList.remove(sumList.size() - 1);
        
        if (start + 1 < candidates.length) {
            // not add, move on
            dfs(candidates, target, results, sum, sumList, start + 1);
        }

    }
}