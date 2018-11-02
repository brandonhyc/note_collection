public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || 
            matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length; 
        int column = matrix[0].length; 

        int x = 0, y = row - 1;
        int count = 0;

        while (y >= 0 && x < column) {
            if (matrix[y][x] < target) {
                x++;
            } else if (matrix[y][x] > target) {
                y--;
            } else if (matrix[y][x] == target) {
                x++;
                y--;
                count++;
            } else {
                return -1;
            }
        }
        return count;

    }
}