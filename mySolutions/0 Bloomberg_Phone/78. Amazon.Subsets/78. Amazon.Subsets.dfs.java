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
        Arrays.sort(nums);
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


    public List<List<Integer>> subsets2(int[] A){
        // Time: O(n)
        // Space: O(1)
        // if (A.length < 3) return 0;

        int res = 0;
        int diff = Integer.MIN_VALUE;
        int count = 0;
        int start = 0;
        for (int i = 1; i < A.length; i++){
            int curDiff = A[i] - A[i - 1];
            if (diff == curDiff){
                count += i - start - 1 > 0 ? i - start - 1 : 0;
            } else {
                start = i - 1;
                diff = currDiff;
                res += count;
                count = 0;
            }
        }
        res += count;
        System.out.println(res);
        return new ArrayList<List<Integer>>();
    }
}

