class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 ) {
            return new ArrayList<>();
        }
        
        int leftEnd = 0;
        int rightEnd = matrix[0].length - 1;
        int topEnd = 0;
        int botEnd = matrix.length - 1;
        
        List<Integer> result = new ArrayList<>();
        
        while (leftEnd <= rightEnd && topEnd <= botEnd) {
            for (int i = leftEnd; i <= rightEnd; i++) {
                result.add(matrix[topEnd][i]);
            }
            topEnd++;
            for(int i = topEnd; i <= botEnd; i++) {
                result.add(matrix[i][rightEnd]);
            }
            rightEnd--;
            if (botEnd >= topEnd) {
                for(int i = rightEnd; i >= leftEnd; i--) {
                    result.add(matrix[botEnd][i]);
                }
                botEnd--;
            }
            if (leftEnd <= rightEnd) {
                for(int i = botEnd; i >= botEnd; i--) {
                    result.add(matrix[i][leftEnd]);
                }
                leftEnd++;
            }
        }
        
        return result;
    }
}