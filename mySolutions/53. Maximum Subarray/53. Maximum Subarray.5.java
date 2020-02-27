class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int curSum = nums[0];
        int maxSum = nums[0];
        int[] range = {0, 0};
        
        for (int i = 1; i < nums.length; i++) {
            if (curSum < 0) {
                range[0] = i;
                curSum = 0;
            }            
            curSum += nums[i];
            if (curSum > maxSum) {
                maxSum = Math.max(curSum, maxSum);
                range[1] = i;
            }
        }
        System.out.printf("%s", Arrays.toString(range));
        return maxSum;
    }
}