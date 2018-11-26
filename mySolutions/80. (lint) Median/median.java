public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public int median(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return petition(nums, 0, nums.length - 1, (nums.length - 1) / 2);
    }

    private int petition(int[] nums, int start, int end, int k) {

        if (start == end) {
            return nums[k];
        }

        int left = start, right = end;
        int pivot = nums[left + (right - left) / 2];

        while (left <= right) {
            
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;

                left++; right--;
            }
        }

        if (k <= right) {
            return petition(nums, start, right, k);
        }
        if (left <= k) {
            return petition(nums, left, end, k);
        }
        return nums[k];
    }
}