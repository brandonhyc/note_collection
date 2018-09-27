public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        int[] temp = nums.clone();
        int len = temp.length;
        int i = len - 1, j = len - 1;

        if (len == 0 || len == 1) {
            return temp;
        }

        while (i > 0 && temp[i] <= temp[i - 1]) {
            i--;
        }

        if (i > 0) {
            while (i > 0 && temp[j] <= temp[i - 1]) {
                j--;
            }

            swap(temp, i - 1, j);
        }

        int left = i, right = len - 1;
        while (left <= right) {
            swap(temp, left, right);
            left++;
            right--;
        }
        return temp;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}