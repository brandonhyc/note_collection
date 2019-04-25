class Solution {
    public boolean canJump(int[] nums) {
        
        boolean[] canGet = new boolean[nums.length];
        canGet[0] = true;
        
        for (int i = 0; i < nums.length; i++) {
            if (!canGet[i]) {
                continue;
            }
            for (int step = 1; step <= nums[i]; step++) {
                if (i + step < nums.length) {
                    canGet[i + step] = true;    
                }
            }
             
        }
        
        return canGet[nums.length - 1];
    }
    
}