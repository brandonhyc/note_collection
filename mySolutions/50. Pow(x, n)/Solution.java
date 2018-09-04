class Solution {

    public double myPow(double x, int n) {
        if (n < 0) {
            return 1.0 / pow(x, -n);
        } else {
            return pow(x, n);
        }
    }

    private double pow(double x, int n) {

        if (n == 0) {
            return 1;
        }
        double anp = pow(x, n / 2);

        if (n % 2 == 1) {
            return anp * anp * x;
        } else {
            return anp * anp;
        }
    }
}