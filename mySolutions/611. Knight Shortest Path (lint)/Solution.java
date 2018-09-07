/**
 * Definition for a point. 
 * class Point { 
 *      int x; int y; 
 *      Point() { x = 0; y = 0; }
 *      Point(int a, int b) { x = a; y = b; } 
 * }
 */

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        
        int count = 0;
        Queue<Point> que = new LinkedList<>();
        
        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};

        que.add(source);

        while (!que.isEmpty()) {
            count++;
            int len = que.size();

            for (int i = 0; i < len; i++) {
                
                Point loc = que.poll();
                grid[loc.x][loc.y] = true;

                for (int n = 0; n < dx.length; n++) {
                    if (loc.x + dx[n] >= 0 && loc.x + dx[n] <= grid.length - 1 &&
                        loc.y + dy[n] >= 0 && loc.y + dy[n] <= grid[0].length - 1) {
                        
                        if ((loc.x + dx[n]) == destination.x && 
                            (loc.y + dy[n]) == destination.y) {
                            return count;
                        }

                        if (grid[loc.x + dx[n]][loc.y + dy[n]] == false) {
                            grid[loc.x + dx[n]][loc.y + dy[n]] = true;
                            que.add(new Point(loc.x + dx[n], loc.y + dy[n]));
                        } 
                    }
                }
            }
            
        }
        return -1;
    }
}