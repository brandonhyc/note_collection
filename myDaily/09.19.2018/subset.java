public class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        Arrays.sort(nums);
        
        dfs(nums, result, 0, new ArrayList<Integer>());        
        return result;
    }

    private void dfs (int[] nums, List result, int index, List subset) {
        
        if (index == nums.length) {
            result.add(subset);
            return;
        }

        List<Integer> one = new ArrayList<>(subset);
        
        one.add(nums[index]);
        
        dfs(nums, result, index + 1, one);

        dfs(nums, result, index + 1, subset);
        return;
    }
}
