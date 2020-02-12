class Solution {
    public int search(int[] nums, int target) {
        
        // [ 4,5,6,7,0,1,2]
        // 1. find the smallest number than larger than the last element (2)
        if (nums.length == 0) {
            return -1;
        }
        if (nums[0] <= nums[nums.length - 1]) {
            return bs(nums, 0, nums.length - 1, target);
        }
        
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        
        int key = nums[right];
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= key) {
                right = mid;
            } else { // nums[mid] > key
                left = mid + 1;
            }
        }
        int peak = left;
        if (left - 1 >= 0 && nums[left - 1] > nums[left] ) {
            peak = left - 1;
        }
        
        int find = -1;
        if (nums[0] <= target) {
            find = bs(nums, 0, peak, target);
        } else {
            find = bs(nums, peak + 1, n - 1, target);
        }
        
        
        return find;
    }
    
    private int bs(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } 
            if (nums[mid] < target) {
                left = mid + 1;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            
        }
        return -1;
    }
}