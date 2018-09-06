class Solution {

    public double myPow(double x, int n) {
    
        boolean isNegative = false;
        if (n < 0) {
            x = 1 / x;
            isNegative = true;
            n = -(n + 1);
        } 

        double ans = 1, tmp = x;

        while (n != 0) {
            if (n % 2 == 1) {
                ans *= tmp;
            }

            tmp *= tmp;
            n = n / 2;
        }

        if (isNegative) {
            ans *= x;
        }
        return ans;

    }
}