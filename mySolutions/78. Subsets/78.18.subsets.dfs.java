public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        if (nums == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> results = new LinkedList<>();
        Arrays.sort(nums);

        dfs(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }

    private void dfs(int[] nums, 
                        int index, List<Integer> subset, 
                        List<List<Integer>> results) {

        if (index == nums.length) {
            List<Integer> resultCopy = new ArrayList<>(subset);
            results.add(resultCopy);
            return;
        }

        subset.add(nums[index]);
        dfs(nums, index + 1, subset, results);

        int size = subset.size();
        subset.remove(size - 1);
        dfs(nums, index + 1, subset, results);

    }
}