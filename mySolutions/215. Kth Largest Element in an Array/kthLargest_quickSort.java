public class Solution {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        // write your code here

        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (n == 0) {
            return -1;
        }

        return petition(nums, n, 0, nums.length - n);

    }

    private int petition(int[] nums, int n, int start, int end) {

        if (start >= end) {
            return nums[n];
        }

        int left = start, right = end;
        int pivot = nums[start + (end - start) / 2];

        while (left <= right) {
            
            while (left <= right && nums[left] < pivot) {
                left++;
            }

            while (left <= right && pivot < nums[right]) {
                right--;
            }

            if (left <= right) {
                int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                left++; right--;
            }
        }

        if (n <= right) {
            return petition(nums, n, start, right);
        }
        if (n >= left) {
            return petition(nums, n, left, end);
        }
        return nums[n];

    }
}