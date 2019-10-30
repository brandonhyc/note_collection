class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix.length == 0) {
            return false;
        }

        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        int left = matrix[0][0];
        int right = matrix[rowNum - 1][r];

        while (left < right) {

            int mid = left + (right - left) / 2;

            if ()
        }

    }
}

Assume you
have an
array of
length n
initialized with all 0's
and are
given k
update operations.

Each operation
is represented
as a triplet:[startIndex,endIndex,inc]
which increments
each element
of subarray A[startIndex...endIndex](startIndex and endIndex inclusive)
with inc.

Return the
modified array
after all
k operations
were executed.