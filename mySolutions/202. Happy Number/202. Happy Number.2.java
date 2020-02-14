class Solution {
    public boolean isHappy(int n) {
        if (n <= 0)
            return false;
        int fast = n;
        int slow = n;

        while (fast != 1 && next(fast) != 1) {
            fast = next(next(fast));
            slow = next(slow);
            // System.out.printf("fast: %d, slow: %d\n", fast, slow);
            if (fast == slow) {
                return false;
            }
        }
        return true;
    }

    int next(int n) {
        int total = 0;

        while (n > 0) {
            int a = n % 10;
            n = n / 10;

            total += a * a;
        }
        return total;
    }
}