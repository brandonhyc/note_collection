public class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        // write your code here

        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];

        List<int[]> doors = new ArrayList<>();
        for (int x = 0; x < rooms.length; x++) {
            for (int y = 0; y < rooms[0].length; y++) {
                if (rooms[x][y] == 0) {
                    doors.add(new int[]{x, y});
                }
            }
        }
        visited = new boolean[rooms.length][rooms[0].length];
        bfs(rooms, visited, doors);
    
    }

    private void bfs(int[][] rooms, boolean[][] visited, List<int[]> doors) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < doors.size(); i++) {
            queue.offer(doors.get(i));
        }

        while (!queue.isEmpty()) {
            int[] room = queue.poll();
            int x = room[0];
            int y = room[1];

            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!(0 <= nx && nx < rooms.length && 
                      0 <= ny && ny < rooms[0].length)) {
                    continue;
                }
                
                if (rooms[nx][ny] == -1) {
                    continue;
                }
                queue.offer(new int[]{nx, ny});

                rooms[x][y] = rooms[nx][ny] + 1 < 0 ? rooms[x][y]:
                                Math.min(rooms[x][y], rooms[nx][ny] + 1);
            }
        }
    }
}