class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        int left = 0;
        int right = rowNum * colNum - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int val = matrix[mid / colNum][mid % colNum];
            if (val == target) {
                return true;
            }
            if (val < target) {
                left = mid + 1;
            } else
                right = mid;
        }
        return matrix[right / colNum][right % colNum] == target;
    }
}