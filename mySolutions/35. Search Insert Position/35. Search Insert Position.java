class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int i = 0;
        
        while (i < nums.length && nums[i] < target) {
            i++;
        }
        
        return i;
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        
        // find the first number that >= target
        
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
        
        if (nums[left] < target) {
            return left + 1;
        }
        
        return left; 
    }
    
//     [ 2  5 ] taget = 1 target 3 target 5 target 6
//            6
//      [2  5] 
//          lr  
    
}