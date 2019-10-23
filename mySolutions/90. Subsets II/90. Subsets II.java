class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, 0, new ArrayList<>());
        return result;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> result, int start, List<Integer> list) {
            
        List<Integer> subset = new ArrayList<>();
        subset.addAll(list);
        result.add(subset);

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            list.add(nums[i]);
            backtrack(nums, result, i + 1, list);
            list.remove(list.size() - 1);
        }
        
        
    }
}