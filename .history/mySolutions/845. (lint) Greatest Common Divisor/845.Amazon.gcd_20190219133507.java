public class Solution {
    /**
    * @param a: the given number
    * @param b: another number
    * @return: the greatest common divisor of two numbers
    */

    // 原理：两个整数的最大公约数等于其中较小的数和两数的差的最大公约数。
    // 例如，252和105的最大公约数是21
    // 252 = 21*12; 105 = 21 * 5；
    // 因为 252 − 105 = 21 × (12 − 5) = 147 ，
    // 所以147和105的最大公约数也是21。
    // a  b  min  |a - b|
    // 15 10 10     5
    // 10 5   5     5  

    public int gcd(int a, int b) {
    // write your code here
        if (a == 0 || b == 0) {
            return -1;
        }
        if (a == 1 || b == 1) {
            return 1;
        }
        if (a == b) {
            return a;
        }

        if (a - b > 0) {
            return gcd(Math.min(a, b), a - b);
        }
        
        return gcd(Math.min(a, b), b - a);
    }
}