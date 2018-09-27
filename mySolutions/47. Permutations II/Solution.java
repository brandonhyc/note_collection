// 易错点1: 如何去重. 很难正确分析. (i > 0 && nums[i] == nums[i - 1])不难. 
//          但是, 需要记住, 要表达, 唯一的特殊情况 i', i'', i'''... 一个接着一个被visited. 
//                               于是按顺序的排列要被continue掉 

public class Solution {
    /*
     * @param : A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }
        Arrays.sort(nums);
        dfs(nums, results, new ArrayList<Integer>(), new boolean[nums.length]);
        return results;
    }
    private void dfs (int[] nums, List<List<Integer>> results, 
                      List<Integer> permutation,
                      boolean[] visited) {
        
        if (nums.length == permutation.size()) {
            results.add(new ArrayList<>(permutation));
            return;
        }// exit
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            } // return the redundant

            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, results, permutation, visited);
            visited[i] = false;
            permutation.add(permutation.size() - 1);

        }

    }
};