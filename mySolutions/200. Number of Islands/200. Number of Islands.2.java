class Solution {
    int result = 0;

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int y = 0; y < grid.length; y++) {

            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == '1') {
                    result++;
                    dfs(grid, x, y);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int x, int y) {
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, -1, 0, 1 };

        grid[y][x] = '0';

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!((nx >= 0 && nx < grid[0].length) && (ny >= 0 && ny < grid.length))) {
                continue;
            }
            if (grid[ny][nx] != '1') {
                continue;
            }

            dfs(grid, nx, ny);
        }

    }
}

class Solution {
    int result = 0;

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int y = 0; y < grid[0].length; y++) {

            for (int x = 0; x < grid.length; x++) {
                if (!visited[x][y] && grid[x][y] == '1') {
                    // System.out.printf("x: %d, y: %d\n", x, y);
                    result++;
                    bfs(grid, visited, x, y);
                }
            }
        }

        return result;
    }

    private void bfs(char[][] grid, boolean[][] visited, int x, int y) {
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, -1, 0, 1 };

        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();

        queueX.offer(x);
        queueY.offer(y);

        while (!queueX.isEmpty()) {
            int size = queueX.size();
            for (int j = 0; j < size; j++) {

                x = queueX.poll();
                y = queueY.poll();

                if (visited[x][y] || grid[x][y] == '0') {
                    continue;
                } else
                    visited[x][y] = true;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (!((nx >= 0 && nx < visited.length) && (ny >= 0 && ny < visited[0].length))) {
                        continue;
                    }
                    queueX.offer(nx);
                    queueY.offer(ny);

                }
            }
        }

    }
}