class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bot = n - 1;
        int count = 1;
        
        while (count <= n * n) {
            
            for (int i = left; i <= right; i++) {
                matrix[top][i] = count;
                count++;
            }
            top++;
            
            for (int i = top; i <= bot; i++) {
                matrix[i][right] = count;
                count++;
            }
            right--;
            
            if (top <= bot) {
                for(int i = right; i >= left; i--) {
                    matrix[bot][i] = count;
                    count++;
                }
                bot--;
            }
            if (top <= bot && left <= right) {
                for(int i = bot; i >= top; i--) {
                    matrix[i][left] = count;
                    count++;
                }
                left++;
                
            }
        }
        
        return matrix;
    }
}