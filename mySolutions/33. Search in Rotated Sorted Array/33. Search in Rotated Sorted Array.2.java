class Solution {
    public int search(int[] nums, int target) {
        
        
        if (nums.length == 0) {
            return -1;
        }
        
        
        int left = 0;
        int right = nums.length - 1;
        
        int end = nums.length - 1;
        while (left < right) {
            
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[end] && target <= nums[end]) {
                left = mid + 1;
            }
            else if (nums[mid] <= nums[end] && target > nums[end]) {
                right = mid;
            }
            else {
                // at the same side
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        
        return nums[left] == target ? left : nums[right] == target ? right : -1;
        
    }
}