class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        
        List<Integer> result = new ArrayList<>();
        
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bot = matrix.length - 1;
        
        while (left <= right && top <= bot) {
            
            for (int i = left; i <= right; i ++) {
                result.add(matrix[top][i]);
            }
            top++;
            
            for (int i = top; i <= bot; i++) {
                result.add(matrix[i][right]);    
            }
            right--;
            
            if (left <= right && top <= bot) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bot][i]);
                }
            }
            bot--;
            
            if (left <= right && top <= bot) {
                for(int i = bot; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            left++;
        }
        
        return result;
        
    }
}