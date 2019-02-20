class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0] == null 
            ||grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        List<Integer> results = new ArrayList<>();
        List<Integer> pathSum = new ArrayList<>();
        pathSum.add(grid[0][0]);

        search(grid, results, pathSum, new int[]{0, 0});
        
        // iterate to get min path sum
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < results.size(); i++) {
            min = Math.min(min, results.get(i));
        }
        return min;
    }

    private void search(int[][] grid, 
        List<Integer> results, 
        List<Integer> pathSum, int[] point) {

        if (point[0] == (grid.length - 1) 
            && point[1] == (grid[0].length - 1)) {

            for (int i = 0; i < pathSum.size(); i++) {
                System.out.printf("%d ", pathSum.get(i));
            }
            System.out.println();
            int sum = 0;
            for (int i = 0; i < pathSum.size(); i++) {
                sum = sum + pathSum.get(i);
            }
            results.add(sum);
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
                pathSum.add(grid[point[0]][point[1]]);
                search(grid, results, pathSum, new int[]{nextX, nextY});    
                pathSum.remove(pathSum.size() - 1);
            }
        }

        return;
    }
}