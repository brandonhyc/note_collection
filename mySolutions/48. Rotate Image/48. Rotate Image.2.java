class Solution {
    public void rotate(int[][] matrix) {
        reverse(matrix);
        
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < x; y++) {
                int temp = matrix[x][y];
                matrix[x][y] = matrix[y][x];
                matrix[y][x] = temp;
            }
        
        }

    }
    
    
    private void reverse(int[][] matrix) {
        int left = 0;
        int right = matrix.length - 1;
        
        while (left < right) {
            int[] temp = matrix[left];
            matrix[left] = matrix[right];
            matrix[right] = temp;
            left++;
            right--;
        }
        
    }
}