class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        
        boolean isCol0Zero = false;
        boolean isRow0Zero = false;
        
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                isCol0Zero = true;
                break;
            }
        }
        // System.out.printf("%s\n", Arrays.deepToString(matrix));
        
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                isRow0Zero = true;
                break;
            }
        }
        // System.out.printf("%s\n", Arrays.deepToString(matrix));
        

        for (int x = 1; x < matrix.length; x++) {
            for (int y = 1; y < matrix[0].length; y++) {
                if (matrix[x][y] == 0) {
                    matrix[x][0] = 0;
                    matrix[0][y] = 0;
                }        
            }
        }

        // System.out.printf("after init 0 set\n%s\n", Arrays.deepToString(matrix));
        
        for (int x = 1; x < matrix.length; x++) {
            if (matrix[x][0] != 0) {
                continue;
            }
            for (int y = 0; y < matrix[0].length; y++) {
                matrix[x][y] = 0;
            }
        }
// System.out.printf("after set all row 0\n%s\n", Arrays.deepToString(matrix));
        
        for (int y = 1; y < matrix[0].length; y++) {
            if (matrix[0][y] != 0) {
                continue;
            }
            for (int x = 0; x < matrix.length; x++) {
                matrix[x][y] = 0;
            }
        }
// System.out.printf("after set all col 0\n%s\n", Arrays.deepToString(matrix));
        
        if (isCol0Zero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        // System.out.printf("%s\n", Arrays.deepToString(matrix));
        
        
        if (isRow0Zero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        // System.out.printf("%s\n", Arrays.deepToString(matrix));
        
    }
}