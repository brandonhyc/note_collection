class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0] == null 
            || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = grid.length - 1; i >= 0 ; i++) {
            for (int j = grid[0].length; j >=0; j++) {
                
                if (i == grid.length && j != grid[0].length) {
                    //on the right edge
                    dp[]
                }
                else if (i != grid.length - 1 && j == grid[0].length - 1) {
                    // bottom edge
                    dp[i][j] = dp[i][j];
                }
                else if (i == grid.length - 1 && j != grid[0].length - 1) {
                    dp[i][j] = grid[i][j];
                }
            }
        }

        return dp()
    }


}