public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (!visited[y][x] && grid[y][x]) {
                    result++;
                    bfs(grid, visited, y, x);
                }
            }
        }

        return result;
    }


    private void bfs(boolean[][] grid, 
                    boolean[][] visited, int originY, int originX) {
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        // four direction

        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();

        queueX.offer(originX);
        queueY.offer(originY);

        while (!queueX.isEmpty()) {
            
            int y = queueY.poll();
            int x = queueX.poll();
            if (visited[y][x]) {
                continue;
            }

            visited[y][x] = true;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (0 <= ny && ny < grid.length &&
                    0 <= nx && nx < grid[0].length) {
                    if (grid[ny][nx] && !visited[ny][nx]) {
                        queueX.offer(nx);
                        queueY.offer(ny);
                    }
                }
            }
        }
    }
}