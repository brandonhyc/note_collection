class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        int mid = 0;
        
        while (mid <= right) {
            if (nums[mid] == 0) {
                int temp = nums[left];
                nums[left] = nums[mid];
                nums[mid] = temp;
                
                left++; mid++;
                
            } 
            else if (nums[mid] == 1) {
                mid++;
            }
            else if (nums[mid] == 2) {
                int temp = nums[right];
                nums[right] = nums[mid];
                nums[mid] = temp;
                
                right--;
            }
        }
        
    }
}