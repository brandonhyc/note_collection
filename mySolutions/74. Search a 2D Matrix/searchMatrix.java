// lint: no.28
// 思路: 关键点在于知道数值和表格位置的转化. 
/**
        0   1   2   3   4
    0   0   1   2   3   4
    1   5   6   7   8   9
    2   10  11  12  13  14
    3  (15)  16  17  18  19
    4   20  21  22  23  24

    15 -> [3][0] = [15 /5 ][15 % 5]
 */

public class Solution {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 ||
            matrix[0] == null || matrix[0].length == 0) {
                return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        int start = 0, end = row * column - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if (matrix[mid / column][mid % column] == target) {
                return true;
            }

            if (matrix[mid / column][mid % column] < target) {
                start = mid;
            }

            if (matrix[mid / column][mid % column] > target) {
                end = mid;
            }
        }
        if (matrix[start / column][start % column] == target ||
            matrix[end / column][end % column] == target){

            return true;
        }

        return false;
    }
}