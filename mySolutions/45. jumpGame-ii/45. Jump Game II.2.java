class Solution {
    public int jump(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int[] steps = new int[nums.length];
        for (int i = 0; i < steps.length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }
        
        steps[0] = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int currentSteps = steps[i];
            
            for (int j = i + 1; j < nums.length && j <= i + nums[i]; j++) {
                if (steps[j] == Integer.MAX_VALUE) {
                    steps[j] = currentSteps + 1;
                }
            }
            
        }
        
        return steps[steps.length - 1];
    }
}