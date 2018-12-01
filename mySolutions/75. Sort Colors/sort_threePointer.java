public class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here

        if (nums == null || nums.length == 0) {
            return;
        }

        int left = 0, right = nums.length - 1;
        
        int index = left;
        while (index <= right) {
            if (nums[index] == 1) {
                index++;
                continue;
            } else if (nums[index] == 0) {
                swap(nums, left, index);
                left++;
                index++;
            } else if (nums[index] == 2) {
                swap(nums, index, right);
                right--;
            }
        }
        return;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
    }
}