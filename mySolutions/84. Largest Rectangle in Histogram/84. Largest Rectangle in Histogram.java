class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        
        int[] prevSmaller = new int[heights.length];
        int[] nextSmaller = new int[heights.length];
        
        for (int i = 0; i < prevSmaller.length; i++) {
            int left = i;
            while (left >= 0 && heights[left] >= heights[i]) {
                left--;
            }
            prevSmaller[i] = left;
        }
        
        for (int i = 0; i < nextSmaller.length; i++) {
            int right = i;
            while (right < heights.length && heights[i] <= heights[right]) {
                right++;
            }
            nextSmaller[i] = right;
        }
        
        // System.out.printf("prevSmaller: %s\n nextSmaller: %s\n", Arrays.toString(prevSmaller), Arrays.toString(nextSmaller));
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(heights[i] * (nextSmaller[i] - prevSmaller[i] - 1), max);
        }
        
        return max;
    }
}