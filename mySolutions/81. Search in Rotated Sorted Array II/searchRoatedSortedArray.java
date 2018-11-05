public class Solution {
    /**
     * @param A: an integer ratated sorted array and duplicates are allowed
     * @param target: An integer
     * @return: a boolean 
     */
    public boolean search(int[] nums, int target) {
        // write your code here

        if (nums == null || nums.length == 0) {
            return false;
        }

        int start = 0, end = nums.length -1;
        int left = 0;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[left] <= target) {
                if (target < nums[mid]) {
                    start = mid;
                }
                if (target )
            }
            if (nums[left] > target) {

            }


        }
    }
}