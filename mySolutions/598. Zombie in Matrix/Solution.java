public class Solution {
    public int zombie(int[][] grid) { 

        if (grid.length == 0) return -1;
        int height = grid.length; int width = grid[0].length; int days = 0;

        Queue<Integer> queX = new LinkedList<>();
        Queue<Integer> queY = new LinkedList<>();
        
        int[] dx = {1, 0, -1, 0}; int[] dy = {0, 1, 0, -1};

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (grid[y][x] == 1) {
                    queX.offer(x); queY.offer(y);
                }
            }
        }

        while (!queX.isEmpty()) {
            int size = queX.size();
            days++;
            for (int n = 0; n < size; n++) {
                int x = queX.poll(); int y = queY.poll();
                for (int d = 0; d < dx.length; d++) {
                    if (x + dx[d] >= 0 && x + dx[d] <= width - 1 &&
                        y + dy[d] >= 0 && y + dy[d] <= height - 1) {
                        if (grid[y + dy[d]][x + dx[d]] == 0) {
                            grid[y + dy[d]][x + dx[d]] = 1;
                            queX.offer(x + dx[d]); 
                            queY.offer(y + dy[d]);
                            if (allFinished(grid)) {
                                return days;
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }

    private static boolean allFinished(int[][] grid) {
        for (int[] y : grid) {
            for (int x : y) {
                if (x == 0)
                    return false;
            }
        }
        return true;
    }
}