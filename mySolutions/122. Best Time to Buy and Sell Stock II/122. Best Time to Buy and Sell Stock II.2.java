class Solution {
    public int maxProfit(int[] prices) {
      
        if (prices.length == 0) {
            return 0;
        }
        
        // preset
        int min = prices[0];
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            
            if (prices[i - 1] >= prices[i]) {
                min = Math.min(prices[i], min);
            } else {
                profit += (prices[i] - min);
                min = prices[i];
            }
            
            
        }
        
        return profit;
    }
}