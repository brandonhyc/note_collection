class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int start = 0;
        int end = 0;
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        
        if ((left > nums.length - 1 || nums[left] != target) && (right < 0 || nums[right] != target)) {
            return new int[] {-1, -1};
        }
        
        if (left >= 0 && nums[left] == target) {
            start = left;
        } else {
            start = right;
        }
        left = start;
        right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        
        if (right <= nums.length - 1 && nums[right] == target) {
            end = right;
        } else {
            end = left;
        }
        
        return new int[] {start, end};
        
    }
}