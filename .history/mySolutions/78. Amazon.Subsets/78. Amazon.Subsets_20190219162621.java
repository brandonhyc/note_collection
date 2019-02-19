public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        results.add(subset);
        
        if (nums == null || nums.length== 0) {

            return new ArrayList<List<Integer>>();
        }
        
        dfs(nums, results, subset);
        
        return results;
    }

    private void dfs(int[] nums, 
        List<List<Integer>> results, 
        List<Integer> subset, int index) {
        
        // exit
        if () {
            
        }
    }
}