class Solution {
    public void wallsAndGates(int[][] rooms) {
        
        if (rooms.length == 0) {
            return;
        }
        
        for (int y = 0; y < rooms.length; y++) {
            for (int x = 0; x < rooms[0].length; x++) {
                if (rooms[y][x] == 0) {
                    dfs(rooms, x, y);
                }
            }
        }
        
        return;
        
    }
    
    private void dfs(int[][] rooms, int x, int y) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        for (int i = 0; i < 4; i++) {
            
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || nx >= rooms[0].length || ny < 0 || ny >= rooms.length) {
                continue;
            }
            if (rooms[ny][nx] == -1) {
                continue;
            }
            if (rooms[ny][nx] <= rooms[y][x] + 1) {
                continue;
            }
            
            rooms[ny][nx] = rooms[y][x] + 1;
            dfs(rooms, nx, ny);
        }
        
    }
}

class Solution {
    public void wallsAndGates(int[][] rooms) {
        
        if (rooms.length == 0) {
            return;
        }
        
        Deque<Integer> queue = new ArrayDeque<>(); 
        
        for (int y = 0; y < rooms.length; y++) {
            for (int x = 0; x < rooms[0].length; x++) {
                if (rooms[y][x] == 0) {
                    queue.offer(y * rooms[0].length + x);
                }
            }
        }
        
        while (!queue.isEmpty()) {
            
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            
            int xy = queue.poll();
                
            for (int i = 0; i < 4; i++) {
                int x = xy % rooms[0].length;
                int y = xy / rooms[0].length;
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                
                if (nx < 0 || nx >= rooms[0].length || ny < 0 || ny >= rooms.length) {
                    continue;
                }
                if (rooms[ny][nx] == -1) {
                    continue;
                }
                if (rooms[ny][nx] <= rooms[y][x]) {
                    continue;
                }
                rooms[ny][nx] = rooms[y][x] + 1;
                queue.offer(nx + ny * rooms[0].length);
                
            }
            
        }
    }
}