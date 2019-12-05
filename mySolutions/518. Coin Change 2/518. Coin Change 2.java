// Time Complexity: O(amount * coins.length), backtracking
class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount + 1];
        return dfs(amount, coins, 0, dp);        
    }
    
    private int dfs(int amount, int[] coins, int start, Integer[][] dp) {
        if (amount == 0) {
            return 1;
        }
        
        if (start >= coins.length) {
            return 0;
        }

        if (dp[start][amount] != null) {
            return dp[start][amount];
        }
        
        int count1 = 0;
        int count2 = 0;
        
        if (amount - coins[start] >= 0) {
            count1 = dfs(amount - coins[start], coins, start, dp);
        }
        
        count2 = dfs(amount, coins, start + 1, dp);
        
        dp[start][amount] = count1 + count2;
        
        return dp[start][amount];
    }
}