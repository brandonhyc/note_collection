class Solution {
    public void rotate(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        // transpose
        for (int i = 0; i < matrix.length; i++) {
            
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp; 
            }
        }

        // reverse 
        int xLength = matrix[0].length;
        // 0 1 2 3
        //   1->2, 4 - 1 - 1


        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][xLength - j - 1];
                matrix[i][xLength - j - 1] = temp;
                System.out.printf("i: %d, j: %d, xLength - i - 1: %d\n", i, j, xLength - i - 1);
            }
        }

        return;
    }
}