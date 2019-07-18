class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // m - rows, n - items in a row
        
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int left = 0, right = m * n - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            // System.out.printf("left: %d, mid: %d, right: %d", left, mid, right);
            
            if (matrix[mid / n][mid % n] == target) {
                return true;
            }
            else if (matrix[mid / n][mid % n] < target) {
                left = mid;
            }
            else if (matrix[mid / n][mid % n] > target) {
                right = mid;
            }
        }
        // System.out.printf("left: %d, right: %d, n: %d, m: %d", left, right, n ,m);
        
        if (matrix[left / n][left % n] == target) {
            return true;
        }
        if (matrix[right / n][right % n] == target) {
            return true;
        }
        
        return false;
    }
}