class Solution {
    public int uniquePaths(int m, int n) {

        int[][] pathSum = new int[n][m];
        
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (x == 0 || y == 0) {
                    pathSum[y][x] = 1;
                }
                else {
                    pathSum[y][x] = pathSum[y - 1][x] + pathSum[y][x - 1];
                }
            }
        }
        
        return pathSum[n - 1][m - 1];
    }
}