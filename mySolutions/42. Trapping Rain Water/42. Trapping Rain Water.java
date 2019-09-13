class Solution {
    public int trap(int[] height) {
        
        if (height.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int total = 0;
        
        int i = 1;
        while (i < height.length) {
            if (stack.isEmpty()) {
                stack.push(i);
                i++;
                continue;
            }
            
            
            int leftHi = height[stack.peek()];
            int rightHi = height[i];
            
            if (leftHi >= rightHi) {
                stack.push(i);
                i++;
            } else {
                int botHi = height[stack.pop()];
                int left = (stack.isEmpty()) ? i : stack.peek();
                leftHi = height[left];
                
                int area = (i - left - 1) * (Math.min(leftHi, rightHi) - botHi);
                total = area >= 0 ? total + area : total;
            }
        } 
        
        return total;
        
    }
}