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

        int start = 0, end = x;

        while (start + 1 < end) {

            int mid = start + (end - start) / 2;
            if (mid == x / mid) {
                end = mid;
                break;
            }
            if (mid * mid < x) {
                start = mid;
            }
            if (mid * mid > x) {
                end = mid;
            }
        }

        System.out.printf("start: %d, end: %d", start, end);
        if (end >= x / end) {
            return end;
        } else {
            return start;
        }
    }
}