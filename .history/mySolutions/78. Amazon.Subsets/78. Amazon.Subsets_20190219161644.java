public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        if (nums == null || nums.length== 0) {
            return new ArrayList<List<Integer>>();
        }
        dfs()
    }
}