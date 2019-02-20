class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0] == null 
            || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        List<Integer> results = new ArrayList<>();
        search(grid, 0, new int[]{0, 0});
        return minSum;
    }

    private int minSum = Integer.MAX_VALUE;
    private void search(int[][] grid, 
        int sum, int[] point) {

        if (point[0] == (grid.length - 1) 
            && point[1] == (grid[0].length - 1)) {
            minSum = Math.min(minSum, sum);
            System.out.println()
            return;
        }

        int[] dx = new int[] {1, 0};
        int[] dy = new int[] {0, 1};

        // if not exit
        for (int i = 0; i < dx.length; i++) {
            int nextX = point[0] + dx[i];
            int nextY = point[1] + dy[i];
            
            if (nextX < grid.length 
                && nextY < grid[0].length) {
                search(grid, sum + grid[nextX][nextY], new int[]{nextX, nextY});    
            }
        }

        return;
    }
}