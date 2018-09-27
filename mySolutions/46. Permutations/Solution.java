public class Solution {
    /*
     * @param nums: A list of integers.
     * 
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }

        dfs(nums, new boolean[nums.length], new ArrayList<>(), results);
        return results;

    }
    private void dfs(int[] nums, 
                     boolean[] visited,
                     List<Integer> permutation,
                     List<List<Integer>> results) {        

        if (nums.length == permutation.size()) {
            results.add(new ArrayList<>(permutation));
            return;
            //exit
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, results);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
        return;
    }
}