        /* brute force:
        *   iterate x and y, compare each pair and get the difference * min(x,y), keep the Max 
        *  psd code
        *  init maxArea = 0;
        *   for (int x = 0; x< height.length; x++) { //1,2
        *       for (int y = x + 1; y < height.length; y++ ) {
        *           int currentArea = (y-x)  * min(height[x], height[y]); 
        *           maxArea = Math.max(currentArea, maxArea);
        *       }
        *   }
        *   return maxArea
        */
        
        /* Smart Way
        *   To minimize comparation times. 1. started from the two ends, 
        *       loop (l and r are different)
        *              maxArea = dist * min(x,y)
        *           2. if l > r, then unit on the right side of l will have smaller area all the time, we skip comparing them by move the pivot(r). 
        *           else vice versa
        *      record the maxArea
        */

class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;
        while (l != r){
            int tmp = Math.min(height[l], height[r]); //* can be removed
            maxArea = Math.max(maxArea, tmp * (r - l));
            if (height[l] > height[r]) {
                r--;
            }
            else {
                l++;
            }
        }
        return maxArea;
    }
}

