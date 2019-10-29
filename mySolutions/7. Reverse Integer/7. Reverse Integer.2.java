class Solution {
    public int reverse(int x) {
        
        int result = 0;
        boolean isNegative = false;
        
        if (x < 0) {
            isNegative = true;   
            x = -x;
        }
        
        
        while (x != 0) {
            int remainder = x % 10;
            if (result > (Integer.MAX_VALUE - remainder) / 10) {
                return 0;
            }
            result = result * 10 + remainder;
            
            // System.out.printf("result: %d, Integer.MAX_VALUE - remainder / 10: %d, * 10: %d\n", result, Integer.MAX_VALUE - remainder, result * 10);
            
            x = x / 10;
        }
        
        return (isNegative) ? -result : result;
        
    }
}