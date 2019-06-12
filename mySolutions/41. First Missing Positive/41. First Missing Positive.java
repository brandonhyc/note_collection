class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        
        if (!hasOne(nums)) {
            return 1;
        }
        if (nums.length == 1) {
            return 2;
        }
        
        clean(nums);
        // System.out.print("after clean: ");
        // System.out.println(Arrays.toString(nums));
        
        mark(nums);
        // System.out.print("after mark: ");
        // System.out.println(Arrays.toString(nums));
        
        return find(nums);
        
    }
    
    private void mark(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] <= 0) {
                continue;
            }
            nums[index] = -nums[index];
        }
    }
    
    private int find(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return i + 1;
        }
        return nums.length + 1;
    }
    
    
    private boolean hasOne(int[] nums) {
        boolean hasOne = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                hasOne = true;
            }
        }
        return hasOne;
    }
    
    private void clean(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }
        return;
    }
}