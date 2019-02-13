public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here

        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);

        int result = 0;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (nums[left] == nums[right]) {
                result++;
                left++;
                right--;
            } 
            else if (nums[left] < nums[right]) {
                left++;
            } 
            else if (nums[left] > nums[right]) {
                right--;
            }
        }
        return result;

    }
}