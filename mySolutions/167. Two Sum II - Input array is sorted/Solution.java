public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    
    public int[] twoSum(int[] nums, int target) {
        // write your code here

        if (nums == null || nums.length == 0 || nums.length == 1) return new int[] {-1, -1};

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1};
            }
            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[] {-2, -2};
    }
}