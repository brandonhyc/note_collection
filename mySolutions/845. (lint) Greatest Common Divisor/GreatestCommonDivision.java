public class Solution {
    /**
     * @param a: the given number
     * @param b: another number
     * @return: the greatest common divisor of two numbers
     */
    public int gcd(int a, int b) {
        // write your code here
        if (a == 0 || b == 0) {
            return -1;
        }
        int larger = Math.max(a, b);
        int smaller = Math.min(a, b);
        
        if (larger % smaller != 0) {
            return gcd(smaller, larger % smaller);
        }
        return smaller;
    }
}
