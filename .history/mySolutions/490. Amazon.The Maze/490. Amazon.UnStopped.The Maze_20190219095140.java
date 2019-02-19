class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        
        return search(maze, start, destination, visited);

    }

    
    private boolean search(int[][] maze, int[] start, int[] dest, boolean[][] visited) {
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        if (visited[start[0]][start[1]]) {
            return false;
        }

        boolean hasPath = false; 
        // if not visited
        visited[start[0]][start[1]] = true;
        // exit
        if (start[0] == dest[0] && start[1] == dest[1]) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            int[] nextStart = new int[]{start[0], start[1]};
            while () {
                nextStart = new int[]{start[0] + dx[i], start[1] + dy[i]};

                if (nextStart[0] < 0 || nextStart[0] >= maze.length
                    || nextStart[1] < 0 || nextStart[1] >= maze[0].length) {
                    break;
                }
                if (maze[nextStart[0]][nextStart[1]] == 1) {
                    break;
                }
            }
            hasPath = hasPath || search(maze, nextStart, dest, visited);
        }
        return hasPath;
    }
}