class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<Integer>();
        }

        List<Integer> result = new ArrayList<>();

        int rowIndex = 0;
        int colIndex = 0;
        int rowSteps = matrix[0].length;
        int colSteps = matrix.length;

        while (rowSteps != 0 || colSteps != 0) {

            for (int x = 0; x < rowSteps; x++) {
                result.add(matrix[rowIndex + x]);
            }
            rowIndex = rowIndex + rowSteps;

            for (int y = 0; y < colSteps; y++) {
                result.add(matrix[colIndex + y]);
            }
            colIndex = colIndex + colSteps;

            for (int x = 0; x < rowSteps; x++) {
                result.add(matrix[rowIndex - x]);
            }
            rowIndex = rowIndex - rowSteps;
            rowSteps--;

            for (int y = 0; y < colSteps; y++) {
                result.add(matrix[colIndex - y]);
            }
            colIndex = colIndex - colSteps;
            colSteps--;
        }

    }
}