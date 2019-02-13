public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int result = 0;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (left < right && left + 1 < nums.length && nums[left] == nums[left + 1]) {
                left++;
                continue;
            }
            if (left < right && right - 1 < nums.length && nums[right] == nums[right - 1]) {
                right--;
                continue;
            }

            if (nums[left] + nums[right] == target) {
                result++;
                left++;
                right--;
            } 
            else if (nums[left] + nums[right] < target) {
                left++;
            } 
            else if (nums[left] + nums[right] > target) {
                right--;
            }
        }
        return result;
    }
}