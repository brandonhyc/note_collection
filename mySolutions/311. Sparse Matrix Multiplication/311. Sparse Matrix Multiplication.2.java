class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        
//         AB (0, 1) = all A row 0 * all B col 1
//                   = 100, 000
//                   = 1 * 0 + 0 * 0 + 0 * 0
        
        if (A.length == 0) {
            return new int[0][0];
        }
        
//         [[1,-5]]
//         [[12],[-1]]
            
            
        int[][] AB = new int[A.length][B[0].length];
        
        for (int x = 0; x < AB.length; x++) {
            
            for (int y = 0; y < AB[0].length; y++) {
                AB[x][y] = 0;
                
                for (int i = 0; i <= A[0].length - 1; i++) {
                    AB[x][y] += A[x][i] * B[i][y];
                }
                
            }
            
        }
        
        return AB;
    }
}