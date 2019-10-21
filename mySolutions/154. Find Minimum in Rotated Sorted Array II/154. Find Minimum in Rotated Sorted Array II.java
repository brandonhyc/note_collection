class Solution {
    public int findMin(int[] nums) {
        
        if (nums.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        int end = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[left] == nums[right]) {
                right = right - 1;
                end = right;
            }
            else if (nums[mid] > nums[end]) {
                left = mid + 1;
            } else {
                right = mid;
            }
            
        }
        
        return nums[right];
    }
}