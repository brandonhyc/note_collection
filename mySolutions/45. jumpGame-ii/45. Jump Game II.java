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
            int canGo = i + nums[i];
            for (int j = i; j <= canGo && j < nums.length; j++) {
                steps[j] = Math.min(steps[j], steps[i] + 1);
            }
            
            // System.out.printf("i:%d, canGo: %d, steps: %s\n", i, canGo, Arrays.toString(steps));
            
        }
        
        return steps[nums.length - 1];
    }
}