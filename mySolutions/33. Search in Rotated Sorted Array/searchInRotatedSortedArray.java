public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0){
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        int t = nums[start];
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[0] < nums[nums.length - 1]){
                start = 0;
                break;
            }
            
            if (nums[mid] > nums[mid + 1]) {
                start = mid;
                break;
            } else if (nums[mid] > t) {
                start = mid;
            } else if (nums[mid] < t) {
                end = mid;
            } else {
                return -1;
            }
        }
        // nums[start] = zenith;

        int left = 0, right = nums.length - 1;
        if (nums[left] <= target && target <= nums[start]) {
            right = start; 
        } else {
            left = start;
        }

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                left = mid;
            }
            if (target < nums[mid]) {
                right = mid;
            }
            if (nums[mid] < target) {
                left = mid;
            }
        }

        if (nums[left] == target) return left;
        if (nums[right] == target) return right;

        return -1;

    }
}