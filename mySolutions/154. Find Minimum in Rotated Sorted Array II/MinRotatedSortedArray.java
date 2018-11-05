//160. Find Minimum in Rotated Sorted Array II
public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        int target = nums[start];

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid + 1 < nums.length && 
                nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[mid] < target) {
                end = mid;
            } else if (nums[mid] > target) {
                start = mid;
            } else if (nums[mid] == target) {
                end--;
            } else {
                start++;
            }
        }

        return Math.min(nums[0], Math.min(nums[start], nums[end]));
    }
}