class Solution {
    int minSteps;
    public int jump(int[] nums) {
        
        if (nums.length == 1) {
            return 0;
        }
        
        int[] minSteps = new int[nums.length];
        for (int i = 1; i < minSteps.length; i++) {
            minSteps[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < nums.length; i++) {
            int right = Math.min(i + nums[i], nums.length - 1); 
            for (int j = i + 1; j <= right; j++) {
                if (minSteps[i] + 1 < minSteps[j]) {
                    minSteps[j] = Math.min(minSteps[i] + 1, minSteps[j]);
                }
            }
        }
        
        return minSteps[nums.length - 1];
    }
}

