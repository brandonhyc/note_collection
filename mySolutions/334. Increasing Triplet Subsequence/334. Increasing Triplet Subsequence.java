class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int hasOnePre = Integer.MAX_VALUE;
        int hasTwoPre = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] <= hasOnePre) {
                hasOnePre = nums[i];
            }
            else if (nums[i] <= hasTwoPre ) {
                hasTwoPre = nums[i];
            } else {
                return true;
            }
        }
        return false;
        
    }
}