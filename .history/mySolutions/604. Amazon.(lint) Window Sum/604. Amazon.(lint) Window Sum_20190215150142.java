public class Solution {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here

        if (nums == null || nums.length < k) {
            return new int[]{};
        }
        int result = int[nums.length - k + 1];         

        int tempSum = 0;
        for (int i = 0; i < k; i++) {
            tempSum += nums[i];
        }
        result[0] = 

        for (int i = 1; i + k - 1 < nums.length; i++) {
            int leftIndex = i;
            int rightIndex = i + k - 1;

            
        } 


    }
}