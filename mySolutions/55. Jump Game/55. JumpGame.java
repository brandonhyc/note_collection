class Solution {
    public boolean canJump(int[] nums) {
        
        int furthest = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            if (furthest < i) {
                return false;
            }
            
            furthest = Math.max(nums[i] + i, furthest);
            
        }
        
        return true;
    }
}