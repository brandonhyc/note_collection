class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        int[][] dp = new int[rowIndex + 1][rowIndex + 1];
        
        for (int i = 0; i < rowIndex + 1; i++) {
            for (int j = 0; j <= i; j++) {
                
                if (j == 0 || i == j) {
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i ++) {
            result.add(dp[rowIndex][i]);
        }
        return result;
    }
}