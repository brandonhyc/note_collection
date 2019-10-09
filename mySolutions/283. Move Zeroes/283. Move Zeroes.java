class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int nonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            nums[nonZero++] = nums[i];
        }
        
        while (nonZero < nums.length) {
            nums[nonZero] = 0;
            nonZero++;
        }
        
    }
}