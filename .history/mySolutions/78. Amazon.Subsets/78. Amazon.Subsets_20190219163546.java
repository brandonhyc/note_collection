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

            return new ArrayList<List<Integer>>();
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
        index = index + 1;
        dfs(nums, results, subset, index);
        // do add
        subset.add(nums[index]);
        dfs(nums, results, subset, index);
        subset.remove(subset.size() - 1);
        
    }
}