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
    }

}