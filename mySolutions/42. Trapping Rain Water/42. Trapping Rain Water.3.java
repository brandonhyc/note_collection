class Solution {
    public int trap(int[] height) {
        
        Stack<Integer> st = new Stack<>();
        
        int index = 0;
        int total = 0;
        while (index <= height.length - 1) {
            int rH = height[index];
            
            if (st.size() == 0 || height[st.peek()] > rH) {
                st.push(index);
                index += 1;
            } else {
                int bot = st.pop();
                if (st.size() == 0) {
                    st.push(index);
                    index += 1;
                    continue;
                }
                int left = st.peek();
                total += (index - left - 1) * (Math.min(height[index], height[left]) - height[bot]);
            }
        }
        return total;        
    }
}