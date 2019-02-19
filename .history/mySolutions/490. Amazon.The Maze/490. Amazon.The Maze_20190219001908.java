class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        
        return search(maze, start, destination, visited);

    }

    private boolean search(int[][] maze, int[] start, int[] dest, boolean[][] visited) {
        if (visited[start]) {
            return false;
        }
    }
}