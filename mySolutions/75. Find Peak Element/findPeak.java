public class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        int result = -1;

        while (true) {
            int mid = start + (end - start) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                result = mid;
                break;
            } else if (nums[mid - 1] > nums[mid] && nums[mid] > nums[mid + 1]) {
                end = mid;
                continue;
            } else if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
                start = mid;
                continue;
            } else if (nums[mid - 1] > nums[mid] && nums[mid] < nums[mid + 1]) {
                start = mid;
                continue;
            } else {
                break;
            }
        }
        return result;
    }

}