class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> results = new ArrayList<>();
        
        Arrays.sort(candidates);
        backtrack(candidates, target, results, new ArrayList<>(), 0, 0);
        
        return results;
    }
    
    private void backtrack(int[] candidates, int target, List<List<Integer>> results, List<Integer> adderList, int sum, int start) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            results.add(new ArrayList<>(adderList));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (i - 1 >= start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            adderList.add(candidates[i]);
            backtrack(candidates, target, results, adderList, sum + candidates[i], i + 1);
            adderList.remove(adderList.size() - 1);
        }
        
        
    }
    
}