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
        0 1 2 3
        [0 1] [1 2] [2 3]

        int result = int[nums.length - k + 1];         
        for (int i = 0; i + k - 1 < nums.length; i++) {
        } 


    }
}