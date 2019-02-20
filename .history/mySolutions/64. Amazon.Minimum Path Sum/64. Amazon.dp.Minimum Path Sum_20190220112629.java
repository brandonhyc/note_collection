class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0] == null 
            || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = grid.length - 1; i >= 0 ; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                
                if (i != grid.length - 1 && j != grid[0].length - 1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
                else if (i != grid.length - 1 && j == grid[0].length - 1) {
                    // bottom edge
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                }
                else if (i == grid.length - 1 && j != grid[0].length - 1) {
                    // right edge
                   
                     System.out.printf("i: %d, j: %d, dp[i][j]: %d\n", i, j, dp[i][j]);

                    dp[i][j] = grid[i][j] + grid[i][j + 1];
                }
                else if (i == grid.length - 1 && j == grid[0].length - 1) {
                    dp[i][j] = grid[i][j];
                }
                    //  System.out.printf("i: %d, j: %d, dp[i][j]: %d\n", i, j, dp[i][j]);


            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.printf("%d ", dp[i][j]);                
            }
            System.out.println();
        }

        return dp[0][0];
    }
}