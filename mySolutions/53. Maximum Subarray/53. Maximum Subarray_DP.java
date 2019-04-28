class Solution {
    
    public int maxSubArray(int[] nums) {
        
        // speical case: all negative???
        int maxSum = 0;
        int maxLinkedSum = 0;
        
        for (int i = 0; i < nums.length; i++) {    
            
            if (i == 0) {
                maxSum = nums[0];
                maxLinkedSum = nums[0];
            }
            
            if (i > 0) {
                maxLinkedSum = (maxLinkedSum + nums[i] > nums[i]) ? maxLinkedSum + nums[i] : nums[i];

                maxSum = Math.max(maxLinkedSum, maxSum);
            }
            
            // System.out.printf("pointer: %d, is: %d, maxSum: %d, maxLinkedSum: %d\n", i, nums[i], maxSum, maxLinkedSum);
            
        }
        
        return maxSum;
    }
}