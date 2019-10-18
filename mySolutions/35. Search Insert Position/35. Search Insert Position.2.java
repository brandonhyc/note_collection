class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        // find the pivot/ min
            
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] <= nums[nums.length - 1] ) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int min = left;
        // System.out.printf("min: %d\n", min);
        if (nums[min] == target) {
            return min;
        }
        
//         1. case /  if (min == nums[0]) left = 0; right = nums.length - 1;
//         2. case / /r if (target <= nums[nums.length - 1]) left = min, right = nums.length - 1;
//         3. case l/ / (if (target > nums[nums.length - 1]) left = 0, right = min;
        
        if (min == 0) {
            left = 0;
            right = nums.length - 1;
        } else if (target <= nums[nums.length - 1]) {
            left = min;
            right = nums.length - 1;
        } else {
            left = 0;
            right = min;
        }
        
        while (left <= right) {
            // System.out.printf("left: %d, right: %d\n", left, right);
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        
        return -1;
    }
}