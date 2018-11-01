public class Solution {
    /**
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        // write your code here

        if (x == 0) {
            if (n < 0) {
                return Double.POSITIVE_INFINITY;
            }
            return 0;
        }

        double result = 1;
        double base = (n > 0) ? x : 1 / x;

        while (n != 0) {
            
            if (n % 2 != 0) {
                result *= base;
            }

            base *= base;
            n /= 2;
        }
        return result;
        
    }
}