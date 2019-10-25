class Solution {
    public int findDuplicate(int[] nums) {
        
        // edge case
        // 1
        // 1 1
        
        // 1 2 2 3 4
        int left = 1;
        int right = nums.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            
            // System.out.printf("left: %d, right: %d, count: %d\n", left, right, count);
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return right; 
    }
}