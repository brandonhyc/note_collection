class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }
        
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        
        int left = 1;
        
        for (int i = 1; i < nums.length; i++) {
            left = left * nums[i - 1];
            result[i] = left * result[i]; 
        }
        
        int right = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right = right * nums[i + 1];
            result[i] = right * result[i];
        }
        
        return result;
    }
}