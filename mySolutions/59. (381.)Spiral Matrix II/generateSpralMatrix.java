public class Solution {
    /**
     * @param n: An integer
     * @return: a square matrix
     */
    public int[][] generateMatrix(int n) {
        // write your code here

        int[][] res = new int[n][n];
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = -1;
            }
        }

        int x = 0, y = 0, d = 0;
        int nx = 0, ny = 0;
        for (int i = 1; i <= n * n; i++) {
            res[y][x] = i;
            ny = y + dy[d];
            nx = x + dx[d];

            if (nx < 0 || nx >= n || 
                ny < 0 || ny >= n ||
                res[ny][nx] != -1) {
                    
                d = (d + 1) % 4;
                ny = y + dy[d];
                nx = x + dx[d];
            }

            y = ny;
            x = nx;

        }

        return res;
    }        

}