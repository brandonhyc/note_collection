class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        
        backtrack(nums, results, visited, new ArrayList<>());
        return results;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> results, boolean[] visited, List<Integer> permutation) {
        // System.out.println(permutation);
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<>(permutation));
        }
        
        for (int i = 0; i < nums.length; i++) {
          
            if (visited[i]) {
                continue;
            }
            if (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }
            visited[i] = true;
            permutation.add(nums[i]);
            
            backtrack(nums, results, visited, permutation);
            
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
            
        }

        
        return;
    }
}