class Solution {
    public void setZeroes(int[][] matrix) {
        
        if (matrix.length == 0) {
            return;
        }
        
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        
        for (int x = 0; x < matrix.length; x++) {
            
            for (int y = 0; y < matrix[0].length; y++) {
                if (matrix[x][y] == 1) {
                    continue;
                }
                if (matrix[x][y] == 0) {
                    if (x == 0) {
                        firstRowHasZero = true;
                    }
                    if (y == 0) {
                        firstColHasZero = true;
                    }
                    if (x != 0 && y != 0) {
                        matrix[x][0] = 0;
                        matrix[0][y] = 0;
                    }
                
                }
            }
        }
        
        
        // System.out.printf("%s\n", Arrays.deepToString(matrix));
        
        for (int y = 1; y < matrix[0].length; y++) {
            if (matrix[0][y] == 0) {
                for (int x = 0; x < matrix.length; x++) {
                    matrix[x][y] = 0;
                }
            }
        }
        for (int x = 1; x < matrix.length; x++) {
            if (matrix[x][0] == 0) {
                for (int y = 0; y < matrix[0].length; y++) {
                    matrix[x][y] = 0;
                }
            }
        }
        
        if (firstRowHasZero) {
            for (int y = 0; y < matrix[0].length; y++) {
                matrix[0][y] = 0;
            }
        }
        if (firstColHasZero) {
            for (int x = 0; x < matrix.length; x++) {
                matrix[x][0] = 0;
            }
        }
        
        return;
    }
}