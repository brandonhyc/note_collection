public class Solution {
    /**
    * @param a: the given number
    * @param b: another number
    * @return: the greatest common divisor of two numbers
    */

    public int gcdArray(int[] array) {
    // write your code here
        if (a == 0 || b == 0) {
            return -1;
        }
    }

    public int gcd(int a, int b) {
    // write your code here
        if (a == 0 || b == 0) {
            return -1;
        }

        if (a == 1 || b == 1) {
            return 1;
        }
        

        return gcd(Math.min(a, b), Math.abs(a - b));
    }
}