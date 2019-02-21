public class Solution {
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here

        if (nums == null|| nums.length == 0) {
            return -1;
        }

        nums.sort();

        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] == 0) {
                return nums[right] - nums[left];
            } 
            else if (nums[left] + nums[right])
        }

        return -1;
    }
}