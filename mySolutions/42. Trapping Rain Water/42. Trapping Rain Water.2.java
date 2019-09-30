class Solution {
    public int trap(int[] height) {
        
        int ptr = 0;
        int total = 0;
        Stack<Integer> stack = new Stack<>();
        while (ptr < height.length) {
            if (stack.isEmpty() || height[stack.peek()] >= height[ptr]) {
                stack.add(ptr);
                ptr++;
            } else {
                int right = ptr;
                int botHeight = height[stack.pop()];
                // System.out.printf("ptr: %d, total: %d, botHeight: %d, right: %d\n", ptr, total, botHeight, right);
                if (stack.isEmpty()) {
                    continue;
                }
                int left = stack.peek();
                int vol = (right - left - 1) * (Math.min(height[left], height[right]) - botHeight); 
                total += vol;
                // System.out.printf("ptr: %d, total: %d, left: %d, botHeight: %d, right: %d, vol: %d\n", ptr, total, left, botHeight, right, vol);
            }
        }
        
        return total;
    }
}