public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here

        if (nums == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> results = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, results, visited, new ArrayList<>());
        return results;
    }

    private void dfs(int[] nums, 
                    List<List<Integer>> results, 
                    boolean[] visited,  
                    List<Integer> combination) {
        if (nums.length == combination.size()) {
            List<Integer> result = new ArrayList<>(combination);
            results.add(result);
            return;
        }
        // procedure not completed  
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            combination.add(nums[i]);
            visited[i] = true;
            dfs(nums, results, visited, combination);
            visited[i] = false;
            int size = combination.size();
            combination.remove(size - 1);
        }
    }
}