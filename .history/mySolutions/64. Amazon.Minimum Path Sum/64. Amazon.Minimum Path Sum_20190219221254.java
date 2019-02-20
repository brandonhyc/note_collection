class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0] == null 
            ||grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        List<Integer> results = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        search(grid, results, path, new int[]{9, 0});
        
        return ;
    }

    private 
}