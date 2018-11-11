public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        // write your code here

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int result = 0;
        int left = 0, right = nums.length - 1;
        while (left >= 0 && 
                right < nums.length && 
                left < right) {
                if (nums[left] + nums[right] <= target) {
                    result += right - left;
                    left++;
                } else {
                    right--;
                }
        }
        return result;
    }
}