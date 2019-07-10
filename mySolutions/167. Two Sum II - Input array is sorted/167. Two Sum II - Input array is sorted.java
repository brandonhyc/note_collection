class Solution {
    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length < 1) {
            return new int[] { -1, -1 };
        }

        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] == target) {
                break;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] { left + 1, right + 1 };

    }
}