class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int colSize = A.length;
        int rowSize = B[0].length;
        
        int[][] C = new int[colSize][rowSize];
        
        for (int x = 0; x < colSize; x++) {
            
            for (int y = 0; y < rowSize; y ++) {
                
                C[x][y] = multiply(A, B, x, y);
            }
        }
        
        return C;
    }
    
    private int multiply(int[][] A, int[][] B, int x, int y) {
        int sum = 0;
        for (int i = 0; i < A[0].length; i++) {
            sum += A[x][i] * B[i][y];
        }
        
        return sum;
    }
}