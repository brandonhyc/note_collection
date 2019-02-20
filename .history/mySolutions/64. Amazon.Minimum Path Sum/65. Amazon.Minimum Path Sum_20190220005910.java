class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0] == null 
            ||grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        List<Integer> results = new ArrayList<>();

        search(grid, results, 0, new int[]{0, 0});
        
        // iterate to get min path sum
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < results.size(); i++) {
            min = Math.min(min, results.get(i));
        }
        return min;
    }

    private void search(int[][] grid, 
        List<Integer> results, 
        int min, int[] point) {

        if (point[0] == (grid.length - 1) 
            && point[1] == (grid[0].length - 1)) {

            // for (int i = 0; i < pathSum.size(); i++) {
            //     System.out.printf("%d ", pathSum.get(i));
            // }
            // System.out.println();
            results.add(min);
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
                pathSum.add(grid[nextX][nextY]);
                search(grid, results, pathSum, new int[]{nextX, nextY});    
                pathSum.remove(pathSum.size() - 1);
            }
        }

        return;
    }
}