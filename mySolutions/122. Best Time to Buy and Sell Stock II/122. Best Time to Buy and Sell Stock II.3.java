class Solution {
    public int maxProfit(int[] prices) {
        
        int total = 0;    
        int last = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i ++) {
            if (last < prices[i]) {
                total += prices[i] - last;
            } 
            last = prices[i];
        }
        
        return total;
    }
}