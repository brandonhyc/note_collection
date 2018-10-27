class fibonacci {
    static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main (String args[]) {
        int n = 9;
        System.out.println(fib(n));
    }
}


/*
https://www.youtube.com/watch?v=pqivnzmSbq4

Time complexity analysis
    Tn = Tn-1 + Tn-2
    T0 = T1 = 1
    1. Lower Bound
        Tn-1 ~ Tn-2
        Tn ~ Tn-2 + Tn-2 + C
           =  (2Tn-4 + C + 2Tn-4 + C) + C
           =  2(2Tn-8 + C) + 2(2Tn-8 + C) + (2 + 1)C
        
        Tn = 8Tn-8 + (4 + 2 + 1)C
        Tn = 2^k*Tn-2k + (2^k-1)C
        let Tn-2k = 0, then n - 2k = 0, k = n/2
        Tn ~ 2^(n/2) * O(1) + C
*/