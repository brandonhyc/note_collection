public class Solution {
    /**
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */

    public double myPow(double x, int n) {
        // write your code here
        if (n > 0) {
            return helper(x, n);
        }

        if (n < 0) {
            return helper(1 / x, n);
        }

        return 1;
    }

    private double helper(double x, int n) {
        if (n == 1 || n == -1) {
            return x;
        } 

        if (n % 2 != 0) {
            return helper(x, n / 2) * helper(x, n / 2) * x;
        }

        return helper(x, n / 2) * helper(x, n / 2);
    }
}