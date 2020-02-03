class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid - 1 < 0 || mid + 1 > nums.length - 1) {
                break;
            }
            
            if (nums[mid - 1] <= nums[mid] && nums[mid] <= nums[mid + 1]) {
                left = mid + 1;
            }
            else if (nums[mid - 1] >= nums[mid] && nums[mid] >= nums[mid + 1]) {
                right = mid - 1;
            }
            else if (nums[mid - 1] <= nums[mid] && nums[mid] >= nums[mid + 1]) {
                return mid;
            }
            else {
                left = mid + 1;
            }
            // System.out.printf("left: %d, right: %d\n", nums[left], nums[right]);
        }
        
        return nums[left] < nums[right] ? right : left;
    }
}