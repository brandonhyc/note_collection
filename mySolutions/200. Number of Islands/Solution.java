
public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        boolean[][] v = new boolean[grid.length][grid[0].length];

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!v[i][j] && grid[i][j]) {
                    bfs(grid, v, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(boolean[][] grid, boolean[][] v, int i, int j) {

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        qx.offer(i);
        qy.offer(j);
        v[i][j] = true;

        while (!qx.isEmpty()) {

            int cx = qx.poll();
            int cy = qy.poll();

            int[] dx = { 1, 0, -1, 0 };
            int[] dy = { 0, 1, 0, -1 };
            for (int x = 0; n < 4; x++) {
                int nx = cx + dx[n];
                int ny = cy + dy[n];

                if (nx >= 0 && nx <= grid.length - 1 && ny >= 0 && ny <= grid[0].length - 1) {

                    if (!v[nx][ny] && grid[nx][ny]) {
                        qx.offer(nx);
                        qy.offer(ny);
                        v[nx][ny] = true;
                    }
                }
            }
        }
    }
}

