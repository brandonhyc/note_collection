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
        int gcdOfAll = array[0];

        for (int i = 1; i < array.length; i++) {
            gcdOfAll = gcd(gcdOfAll, array[i]);
        }
        return gcdOfAll;

    }

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

        return gcd(Math.min(a, b), Math.abs(a - b));
    }
}