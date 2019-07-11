class Solution {
    public int numIslands(char[][] grid) {
        
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    if (grid[i][j] == '1') {
                        count++;
                        bfs(grid, visited, i, j);
                    }
                }
            }
        }
        
        return count;
    }
    
    private void bfs(char[][] grid, boolean[][] visited, int x, int y) {
        int[] dx = new int[] {1, 0, -1, 0};
        int[] dy = new int[] {0, 1, 0, -1};
        
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        
        qx.offer(x);
        qy.offer(y);
        
        while (!qx.isEmpty()) {
            x = qx.poll();
            y = qy.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!(0 <= nx && nx < grid.length && 0 <= ny && ny < grid[0].length)) {
                    continue;
                }

                if (!visited[nx][ny] && grid[nx][ny] == '1') {
                    qx.offer(nx);
                    qy.offer(ny);
                    visited[nx][ny] = true;
                }

            }              
            
        }

    }
}