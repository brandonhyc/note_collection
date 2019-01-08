public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here

        if (nums == null) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, results, visited, new ArrayList<>() );

        return results;

    }
    
    private void dfs(int[] nums, 
                List<List<Integer>> results, 
                boolean[] visited,
                List<Integer> combination ) {
        
        if (nums.length == combination.size()) {
            results.add(new ArrayList<>(combination));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i -1] && !visited[i - 1]) {
                continue;
            }

            combination.add(nums[i]);
            visited[i] = true;

            dfs(nums, results, visited, combination);

            int size = combination.size();
            visited[i] = false;

            combination.remove(size - 1);
        }
    }
};