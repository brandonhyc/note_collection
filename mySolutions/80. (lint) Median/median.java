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

    }
    private int sub(int nums, int start, int end, int size) {

        if (left == right) {
            return nums[k];
        }

        int start = left;
        int end = right;
        int pivot = nums[(end - start) / 2 + start];

        while (start <= end) {
            while (nums[start] < pivot && start <= end) {
                start++;
            }
            while (nums[end] > pivot && start <= end) {
                end--;
            }
            if (start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        
    }
}