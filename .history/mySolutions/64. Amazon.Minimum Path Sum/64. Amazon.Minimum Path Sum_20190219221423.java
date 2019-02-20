class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0] == null 
            ||grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        List<Integer> results = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        search(grid, results, path, new int[]{0, 0});
        
        // iterate to get min path sum
        return ;
    }

    private void search(int[][] grid, List<Integer> results, List<Integer>)
}