public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int findPosition(int[] nums, int target) {
        // write your code here
        if (nums.length == 0 || nums == null) {
            return -1;
        }
        return helper(nums, 0, nums.length - 1, target);
    }

    private int helper(int[] nums, int start, int end, int target) {
        if (start > end || end >= nums.length) {
            return -1;
        }
        int mid = (start + end) /2;

        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return helper(nums, mid + 1, end, target);
        }
        if (nums[mid] > target) {
            return helper(nums, start, mid - 1, target);
        }
        return -1;
    }
}