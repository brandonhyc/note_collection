class Solution {
    public int minPathSum(int[][] grid) {
        int[][] M = new int[grid.length][grid[0].length];
        // M[i][j] represents the min sum path from (0, 0) to (i, j) inclusive
        M[0][0] = grid[0][0];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (i != 0 || j != 0) {
                    int temp = Integer.MAX_VALUE;
                    if (i - 1 >= 0) temp = Math.min(temp, grid[i][j] + M[i - 1][j]);
                    if (j - 1 >= 0) temp = Math.min(temp, grid[i][j] + M[i][j - 1]);
                    M[i][j] = temp;   
                }
            }
        }
        
        return M[grid.length - 1][grid[0].length - 1];
    }
}