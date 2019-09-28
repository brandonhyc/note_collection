class Solution {
    public void rotate(int[][] matrix) {
        
        int top = 0; 
        int bot = matrix.length - 1;
        
        while (top < bot) {
            int[] temp = matrix[top];
            matrix[top] = matrix[bot];
            matrix[bot] = temp;
            
            top++;
            bot--;
        }
        
        // swap the symmetry
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < x && y < matrix[0].length; y++) {
                int temp = matrix[x][y];
                matrix[x][y] = matrix[y][x];
                matrix[y][x] = temp;
            }
        }
    }
}