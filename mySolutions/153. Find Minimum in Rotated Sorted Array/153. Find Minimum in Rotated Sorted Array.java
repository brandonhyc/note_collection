class Solution {
    public int findMin(int[] nums) {
        
//               x   3
//         4 5 6 1 2 3
//         l     m   r
//               lr
                  
//         1
//         mr  l return r
                  
//         2 1 
//           lr
        
//         1 2
//           lr
                  
        if (nums.length == 0) {
            return -1;
        }
                  
        if (nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        int target = nums[nums.length - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] >= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
            
        }
        
        return nums[right];
    }
}