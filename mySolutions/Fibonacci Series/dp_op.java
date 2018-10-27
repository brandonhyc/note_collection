class fibonacci {
    static int fib(int n) {
        int a = 0, b = 1, c;
        if (n == 0) {
            return n;
        }

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
    }
}