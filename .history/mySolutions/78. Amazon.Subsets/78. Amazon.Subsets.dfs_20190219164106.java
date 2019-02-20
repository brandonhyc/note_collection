public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        
        if (nums == null || nums.length== 0) {
            results.add(subset);
            return results;
        }
        
        dfs(nums, results, subset, 0);
        
        return results;
    }

    private void dfs(int[] nums, 
        List<List<Integer>> results, 
        List<Integer> subset, int index) {
        
        // exit
        if (index == nums.length) {
            results.add(new ArrayList<Integer>(subset));
            return;
        }

        // if not yet
        // do not add 
        dfs(nums, results, subset, index + 1);
        // do add
        subset.add(nums[index]);
        dfs(nums, results, subset, index + 1);
        subset.remove(subset.size() - 1);
        return;
    }
}