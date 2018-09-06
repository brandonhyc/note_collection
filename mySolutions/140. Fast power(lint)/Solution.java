class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */

                /* DID NOT PASS*/
    public int fastPower(int a, int b, int n) {
        // (a ^ n) %b
        
        // if (a < 0 || b < 0 || n < 0) return -1;

        if (a == 0) return 0;
        if (a == 1) return 1 % b;

        if (n == 0) return 1 % b;
        if (n == 1) return a % b; 
        // (a % b) * (c % b) % b
        // ((a/2 % b) * (a/2 % b)) % b

        long product = fastPower(a, b, n / 2);
        product = (product * product) % b;
        if (n % 2 == 1) {
            product = (product * (a % b)) % b;
        } 

        return (int) product;
    }
}
