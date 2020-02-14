class Solution {
    public boolean isHappy(int n) {
        if (n <= 0) return false;
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
    private int next(int n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        int total = 0;
        for (char ch : s.toCharArray()) {
            int val = Character.getNumericValue(ch);
            total += val * val;
            // System.out.printf("c: %c, val: %d, total: %d\n", ch, val, total);
        }
        sb.append(String.valueOf(total));
        
        // System.out.printf("n: %d, sb: %s\n", n, sb.toString());
        return Integer.valueOf(sb.toString());
    }
}