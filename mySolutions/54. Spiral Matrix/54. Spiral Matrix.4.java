class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        List<Integer> res = new ArrayList<>();
        int[][] DIRS = new int[][]{ {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        boolean[][] visited = new boolean[rows][cols];
        int dirIndex = 0;
        
        int cx = 0;
        int cy = 0;
        
        while (res.size() < rows * cols) {
            res.add(matrix[cy][cx]);
            visited[cy][cx] = true;

            int nx = cx + DIRS[dirIndex][1];
            int ny = cy + DIRS[dirIndex][0];
            if (nx >= 0 && nx <= cols - 1 && ny >= 0 && ny <= rows - 1 && !visited[ny][nx]) {
                // put the cur ele in the res arr, and update the cur pointer
                cx = nx;
                cy = ny;
            } else {
                //change direction
                dirIndex = (dirIndex + 1) % 4;
                cx += DIRS[dirIndex][1];
                cy += DIRS[dirIndex][0];
            } 
            
        }
        
        return res;
    }
}