class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0] == null 
            || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int[][] dpPathSum = new int[grid.length][grid[0].length];
        
        for (int i = 0; i < dpPathSum.length; i++) {
            Arrays.fill(dpPathSum[i], Integer.MAX_VALUE);
        }

        return dp()
    }

    private int calculate(int[][] grid, int[][] dpPathSum, int x, int y) {
        //exit
        if (x == 0 && y == 0) {
            return grid[x][y];
        }
        if (x >= grid.length || y >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        
        dpPathSum[x][y] = grid[x][y] + Math.min(dpPathSum[x- 1][y], grid[x][y] + )
    }

}