class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0] == null 
            || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }
                else if (i == grid.length && j != grid[0].length) {
                    //on the right edge
                    dp[]
                }
            }
        }

        return dp()
    }


}