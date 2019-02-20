class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0] == null 
            ||grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        List<Integer> results = new ArrayList<>();
        List<Integer> pathSum = new ArrayList<>();

        search(grid, results, pathSum, new int[]{0, 0});
        
        // iterate to get min path sum
        return ;
    }

    private void search(int[][] grid, 
        List<Integer> results, 
        List<Integer> pathSum, int[] point) {

        if (point[0] == (grid.length - 1) 
            && point[1] == (grid[0].length - 1)) {
            int lastValue = grid[grid.length - 1][grid[0].length - 1];
            pathSum.add(lastValue);

            int sum = 0;
            for (int i = 0; i < path.size(); i++) {
                sum = sum + path.get(i);
            }
        }

        int dx = new int[] {1, 0};
        int dy = new int[] {0, 1};

    }
}