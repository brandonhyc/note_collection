public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */


    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);

        Queue<List> queue = new LinkedList<>();
        List<Integer> dummy = new ArrayList<Integer>();
        queue.offer(dummy);

        while(!queue.isEmpty()) {
            List<Integer> subset = queue.poll();
            result.add(subset);

            for (int i = 0; i < nums.length; i++) {
                List<Integer> nextSubset = new ArrayList<Integer>(subset);
                if (subset.size() == 0) {
                    nextSubset.add(nums[i]);
                    queue.add(nextSubset);

                } else if (subset.get(subset.size() - 1) < nums[i]){
                    nextSubset.add(nums[i]);
                    queue.add(nextSubset);

                }
            }
        }
        return result;
    }
}

//  DFS
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

    private void dfs(int[] nums, List result, int index, List subset) {

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