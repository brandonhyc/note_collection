public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // write your code here

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;

        Arrays.sort(nums);


        int left = 0, right = nums.length - 1;

        // [0 1 2 3 4] 3
        //  4 = 4 - 0
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                result += right - left;
                left++;
            } else {
                right--;
            }
        }
        return result;

    }
}