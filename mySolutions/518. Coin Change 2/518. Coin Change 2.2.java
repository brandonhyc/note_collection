class Solution {
    public int change(int amount, int[] coins) {
        // iterate through all type of coins, for each type 'c'
        // 1. if does not excess amount, create a new subset includes one quantity of 'c', recursively process the rest amount of money
        // 2. create a new subset, do not include type 'c' anymore, recursively process the rest amount 
        
        if (coins.length == 0) {
            return (amount == 0) ? 1 : 0;
        }
        
        int[][] dp = new int[coins.length][amount + 1];
        
        for (int i = 0; i < coins.length; i++) {
            
            for (int j = 0; j <= amount; j++) {
                
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                
                int count1 = 0;
                int count2 = 0;
                
                if (j - coins[i] >= 0) {
                    count1 = dp[i][j - coins[i]];
                }
                
                if (i - 1 >= 0) {
                    count2 = dp[i - 1][j];
                }
                
                dp[i][j] = count1 + count2;
                
            }
        }
        
        // System.out.println(Arrays.deepToString(dp));
        return dp[coins.length - 1][amount];
    }
}