class Solution {
    public int coinChange(int[] coins, int amount) {
        
        // f(x) = Math.min(f(x - 2), f(x - 3)...) + 1
        
        int[] M = new int[amount + 1];
        
        // M[0] = 0
        for (int i = 1; i <= amount; i++) {
            M[i] = -1;
            
            for (int j = 0; j < coins.length; j++) {
                
                int value = coins[j];
                if (i - value >= 0 && M[i - value] != -1){
                    M[i] = (M[i] == -1) ? M[i - value] + 1 : Math.min(M[i - value] + 1, M[i]);
                }
            }
            
        }
        
        return M[amount];
    }
}