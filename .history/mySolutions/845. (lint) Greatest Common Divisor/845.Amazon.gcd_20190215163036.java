public class Solution {
    /**
    * @param a: the given number
    * @param b: another number
    * @return: the greatest common divisor of two numbers
    */

    a  b  min  |a - b|
    15 10 10     5


    public int gcd(int a, int b) {
    // write your code here
        if (a == 0 || b == 0) {
            return -1;
        }
        if (a == 1 || b == 1) {
            return 1;
        }

        if (a - b > 0) {
            return gcd(Math.min(a, b), a - b);
        } else if (a - b <= 0) {
            return gcd(Math.min(a, b), b - a);
        }
    }
}