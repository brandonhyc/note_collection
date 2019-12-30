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

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new LinkedList<Integer>());

        while (!queue.isEmpty()) {
            
            List<Integer> result = queue.poll();
            results.add(result);

            for (int i = 0; i < nums.length; i++) {
                int size = result.size();
                int lastNum = size == 0 ? Integer.MIN_VALUE : result.get(size - 1);
                int nextNum = nums[i];

                if (lastNum > nextNum) {
                    continue;
                }

                if (size == 0 || lastNum < nextNum) {
                    List<Integer> combination = new LinkedList<>(result);
                    combination.add(nextNum);
                    queue.offer(combination);   
                }
            }

        }

        return results;
    }
}