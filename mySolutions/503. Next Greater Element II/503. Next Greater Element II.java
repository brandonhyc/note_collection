class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int[] result = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            result[i] = getNextGreaterElement(nums, i);
            
        }
        return result;
    }
    
    private int getNextGreaterElement(int[] nums, int start) {
        int result = -1;
        int index = start + 1;
        
        while (index != start) {
            if (index > nums.length - 1) {
                index = 0;
                continue;
            }
            else if (index <= nums.length - 1) {
                if (nums[start] < nums[index]) {
                    result = nums[index];
                    break;
                }
                index++;
            }
        }
        
        return result;
    }
    
}