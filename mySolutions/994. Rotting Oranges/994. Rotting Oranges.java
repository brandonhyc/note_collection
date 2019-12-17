class Solution {
    public int orangesRotting(int[][] grid) {

        int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int timer = 0;
        Queue<int[]> queue = new LinkedList<>();

        int freshCount = 0;
        int rottenCount = 0;

        // oranges get rotten each day
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 2) {
                    queue.offer(new int[] { y, x });
                    rottenCount += 1;
                }
                if (grid[y][x] == 1) {
                    freshCount += 1;
                }
            }
        }

        if (freshCount == 0) {
            return 0;
        }

        while (queue.size() != 0) {
            timer += 1;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] rotten = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = rotten[0] + direction[i][0];
                    int nx = rotten[1] + direction[i][1];

                    if (nx < 0 || nx > grid[0].length - 1 || ny < 0 || ny > grid.length - 1) {
                        continue;
                    }
                    if (grid[ny][nx] == 1) {
                        grid[ny][nx] = 2;
                        freshCount -= 1;
                        rottenCount += 1; // not necessary but for tracking purpose
                        queue.add(new int[] { ny, nx });
                    }
                }
            }

            if (freshCount == 0) {
                return timer;
            }

        }

        return -1;
    }

}