public class Solution {
    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums) {
        // write your code here

        List<Integer> list = new ArrayList<>();

        for (Object num : nums) {
            list.add((int) num * -1);
        }

        int max = Integer.MIN_VALUE;
        int minSum = 0;
        int sum = 0;

        for (int i = 0; i < nums.size(); i++) {
            sum += list.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }

        return max * -1;
    }
}