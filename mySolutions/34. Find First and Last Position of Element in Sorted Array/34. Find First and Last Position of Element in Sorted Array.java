class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        
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
        
        int leftRes = left;
        
        if (nums[leftRes] != target) {
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
        int rightRes = right;
        if (nums[rightRes] == target) {
            return new int[]{leftRes, rightRes};
        }
        return new int[]{leftRes, rightRes - 1};
    }
}