class Solution {
    public int[][] generateMatrix(int n) {
        
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bot = n - 1;
        
        int[][] result = new int[n][n];
        
        int count = 1;
        while (left <= right && top <= bot) {
            
            for (int i = left; i <= right; i++) {
                result[top][i] = count;
                count++;
            }
            top++;
            
            for (int i = top; i <= bot; i++) {
                result[i][right] = count;
                count++;
            }
            right--;
            
            if (top <= bot) {
                for (int i = right; i >= left; i--) {
                    result[bot][i] = count;
                    count++;
                }
            }
            bot--;
            
            if (left <= right) {
                for (int i = bot; i >= top; i--) {
                    result[i][left] = count;
                    count++;
                }
            }
            left++;
        }
        
        return result;
    }
}