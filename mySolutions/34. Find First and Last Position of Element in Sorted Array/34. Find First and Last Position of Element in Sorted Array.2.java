class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int leftEnd = 0;
        int rightEnd = 0;
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        leftEnd = right;
        if (nums.length == 0 || nums[leftEnd] != target) {
            return new int[]{-1, -1};
        }
        
        left = 0;
        right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        rightEnd = (nums[right] == target) ? right : right - 1;
        
        return new int[]{leftEnd, rightEnd};
    }
}