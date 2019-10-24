class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[rowNum - 1][colNum - 1];

        while (left < right) {

            int mid = left + (right - left) / 2;
            int inlineLower = colNum - 1;
            int lowerCount = 0;

            for (int i = 0; i < rowNum; i++) {
                while (inlineLower >= 0 && matrix[i][inlineLower] > mid) {
                    inlineLower--;
                }
                lowerCount += inlineLower + 1;    
            }
            if (lowerCount >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}