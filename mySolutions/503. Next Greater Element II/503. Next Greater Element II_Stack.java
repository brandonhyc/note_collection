class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        res[nums.length - 1] = -1;
        
        for (int i = nums.length - 2; i >= 0; i--) {
            while (!stack.empty() && nums[i] >= stack.peek()) {
                stack.pop();
            } 
            if (!stack.empty() && stack.peek() > nums[i]) {
                res[i] = stack.peek();
            } else if (stack.empty()) {
                res[i] = -1;
            }
            stack.push(nums[i]);
        }
                
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.empty() && nums[i] >= stack.peek()) {
                stack.pop();
            } 
            if (!stack.empty() && stack.peek() > nums[i]) {
                res[i] = stack.peek();
            } else if (stack.empty()) {
                res[i] = -1;
            }
            stack.push(nums[i]);
        }        
        
        return res;

        
    }
    
}