class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> results = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        
        backtrack(nums, results, new ArrayList<>(), isUsed);
        return results;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> results, List<Integer> permutation, boolean[] isUsed) {
        // System.out.println(permutation);
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<>(permutation));
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) {
                continue;
            }
            if (i - 1 >= 0 && nums[i - 1] == nums[i] && !isUsed[i - 1]) {
                continue;
            }
            
            permutation.add(nums[i]); 
            isUsed[i] = true;
            backtrack(nums, results, permutation, isUsed);
            permutation.remove(permutation.size() - 1); 
            isUsed[i] = false;
        }
        
        return;
    }
}