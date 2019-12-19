import java.util.*;

// https://leetcode.com/discuss/interview-question/356150
public class Main {
    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public static int minDist(char[][] grid) {
        Queue<int[]> path = new LinkedList<>();
        int steps = 0;
        // add starting points
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 'S') {
                    path.add(new int[] { y, x });
                    grid[y][x] = 'V';
                }
            }
        }

        while (path.size() != 0) {
            int size = path.size();
            steps += 1;

            for (int i = 0; i < size; i++) {
                int[] point = path.poll();

                for (int j = 0; j < DIRS.length; j++) {
                    int ny = point[0] + DIRS[j][0];
                    int nx = point[1] + DIRS[j][1];

                    if (!isSafe(grid, ny, nx)) {
                        continue;
                    }

                    if (grid[ny][nx] == 'X') {
                        return steps;
                    }
                    if (grid[ny][nx] == 'O') {
                        path.add(new int[] { ny, nx });
                        grid[ny][nx] = 'V';
                    }
                }
            }
        }
        return -1;

    }

    static private boolean isSafe(char[][] grid, int ny, int nx) {
        return ny >= 0 && ny < grid.length && nx >= 0 && nx < grid[0].length && grid[ny][nx] != 'D';
    }

    public static void main(String[] args) {
        char[][] grid = { { 'S', 'O', 'O', 'S', 'S' }, { 'D', 'O', 'D', 'O', 'D' }, { 'O', 'O', 'O', 'O', 'X' },
                { 'X', 'D', 'D', 'O', 'O' }, { 'X', 'D', 'D', 'D', 'O' } };
        test(minDist(grid), 3);
    }

    private static void test(int actual, int expected) {
        if (actual == expected) {
            System.out.println("PASSED!");
        } else {
            System.out.println(String.format("FAILED! Expected: %d, but got: %d", expected, actual));
        }
    }
}