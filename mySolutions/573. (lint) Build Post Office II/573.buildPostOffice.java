public class Solution {
    /**
     * @param grid: a 2D grid
     * @return: An integer
     */
    public int shortestDistance(int[][] grid) {
        // write your code here

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        List<Integer> houseX = new ArrayList<>();
        List<Integer> houseY = new ArrayList<>();

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) {
                    houseX.add(x);            
                    houseY.add(y);            
                }
            }
        }

        // build a matrix for each house
        List<int[][]> matrixs = new ArrayList<>();
        for (int i = 0; i < houseX.size(); i++) {
            
            matrixs.add(new int[grid.length][grid[0].length]);
            int[][] matrix = matrixs.get(i);

            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[0].length; y++) {
                    matrix[x][y] = grid[x][y] == 0 || grid[x][y] == 1 ? Integer.MAX_VALUE : -1;
                }
            }
        }

        // compute distance to each house
        for (int i = 0; i < houseX.size(); i++) {
            bfs(matrixs.get(i), houseX.get(i), houseY.get(i));
        }

        // compute sum of distance
        int[][] sumDistance = new int[grid.length][grid[0].length];
        for (int i = 0; i < houseX.size(); i++) {
            
            int[][] matrix = matrixs.get(i); 
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[0].length; y++) {
                    sumDistance[x][y] = sumDistance[x][y] + matrix[x][y];
                }
            }
            printMatrix(matrix);
        }

        // get the minimum
        int minX = -1;
        int minY = -1;
        int minimumDistance = Integer.MAX_VALUE;
        for (int x = 0; x < sumDistance.length; x++) {
            for (int y = 0; y < sumDistance[0].length; y++) {
                if (sumDistance[x][y] <= 0) {
                    continue;
                }
                if (sumDistance[x][y] < minimumDistance) {
                    minimumDistance = sumDistance[x][y];
                    minX = x;
                    minY = y;
                }
            }
        }

        int minimumPossibleDistance = Integer.MAX_VALUE;
        for (int x = 0; x < sumDistance.length; x++) {
            for (int y = 0; y < sumDistance[0].length; y++) {
                if (sumDistance[x][y] <= 0) {
                    continue;
                }

                if (grid[x][y] == 0 && 
                    sumDistance[x][y] < minimumPossibleDistance) {
                    minimumPossibleDistance = sumDistance[x][y];
                }
            }
        }

        // check if the smallest is on the house
        if (minimumDistance == minimumPossibleDistance) {
            return minimumDistance;
        }

        return -1;
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void bfs(int[][] matrix, int houseX, int houseY) {
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        // change house
        matrix[houseX][houseY] = 0;

        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();

        queueX.offer(houseX);
        queueY.offer(houseY);

        while (!queueX.isEmpty()) {
            int x = queueX.poll();
            int y = queueY.poll();

            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!(0 <= nx && nx < matrix.length &&
                      0 <= ny && ny < matrix[0].length)) {
                    continue;          
                }

                if (matrix[nx][ny] < 0) {
                    continue;
                }
                    // Integer.MAX_VALUE + 1 < 0
                int distance = matrix[nx][ny] + 1 < 0 ? 
                                matrix[x][y] : 
                                Math.min(matrix[x][y], matrix[nx][ny] + 1);
                matrix[x][y] = distance;

                if (!visited[nx][ny]) {
                    queueX.offer(nx);
                    queueY.offer(ny);
                }
            }
        }
    }
}