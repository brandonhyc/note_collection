public class Solution {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */

     // a^n % b 
    public int fastPower(int a, int b, int n) {
        // write your code here

        int base = a;

        while (n != 1) {
            base = (base % b * base % b) % b;
            if (n % 2 != 0) {
                base = (base * a % b) % b;
            }
            n /= 2;
        }
        return base;
    }
}