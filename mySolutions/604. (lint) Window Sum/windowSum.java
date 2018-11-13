public class Solution {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here

        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        if (nums.length < k) {
            return new int[]{};
        }

        List<Integer> list = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < k; i++) {
            result += nums[i];
        }
        list.add(result);


        for (int i = 1; i + k - 1 < nums.length; i++) {
            result -= nums[i - 1];
            result += nums[i + k - 1];
            list.add(result);
        }

        int[] results = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            results[i] = list.get(i);
        }

        return results;
    }
}