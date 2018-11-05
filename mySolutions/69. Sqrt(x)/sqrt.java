public class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if (x <= 0) {
            return 0;
        }

        int result = 0;
        
        while (Math.pow(result + 1, 2) <= x) {
            int adder = 1;
            while (Math.pow((result + adder * 2), 2) <= x) {
                adder *= 2;
            }

            result += adder;
        }
        return result;
    }
}