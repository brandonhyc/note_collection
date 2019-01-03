public class Solution {
    /**
     * @param dividend: the dividend
     * @param divisor: the divisor
     * @return: the result
     */
    public int divide(int dividend, int divisor) {
        // write your code here
        if (divisor == 0) {
            return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } 
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend > 0 && divisor < 0) ||
                             (dividend < 0 && divisor > 0);
        
        long positiveDividend = Math.abs((long) dividend);
        long positiveDivisor = Math.abs((long) divisor);

        int result = 0;

        while (positiveDividend >= positiveDivisor) {
            int shiftTime = 0;
            // m << n means m ^ 2*n 
            while (positiveDividend >= (positiveDivisor << shiftTime)) {
                shiftTime++;
            }

            positiveDividend -= positiveDivisor << (shiftTime -1);
            result +=  1 << (shiftTime - 1);
        }

        return isNegative ? -result : result;
    }
}