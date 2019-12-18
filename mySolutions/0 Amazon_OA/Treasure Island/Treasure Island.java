import java.util.*;

public class Main {
    private static final int[][] DIRS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public static int minSteps(char[][] grid) {
        if (grid.length == 0) {
            return -1;
        }

        int steps = 0;
        Queue<int[]> queue = new LinkedList<>();
        grid[0][0] = 'V';
        queue.offer(new int[] { 0, 0 });

        while (queue.size() != 0) {
            int size = queue.size();
            steps += 1;
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int j = 0; j < DIRS.length; j++) {
                    int ny = pos[0] + DIRS[j][0];
                    int nx = pos[1] + DIRS[j][1];

                    if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) {
                        continue;
                    }
                    if (grid[ny][nx] == 'X') {
                        return steps;
                    }
                    if (grid[ny][nx] == 'O') {
                        grid[ny][nx] = 'V';
                        queue.offer(new int[] { ny, nx });
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        char[][] grid = { { 'O', 'O', 'O', 'O' }, { 'D', 'O', 'D', 'O' }, { 'O', 'O', 'O', 'O' },
                { 'X', 'D', 'D', 'O' } };
        System.out.println(minSteps(grid));
    }
}