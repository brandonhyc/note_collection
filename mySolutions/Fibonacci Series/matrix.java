/**
    This another O(n) which relies on the fact that 
    if we n times multiply the matrix M = {{1,1},{1,0}} to 
    itself (in other words calculate power(M, n)), 
    then we get the (n+1)th Fibonacci number as 
    the element at row and column (0, 0) in the resultant matrix.

    matrix: https://www.geeksforgeeks.org/matrix-exponentiation/
    O(logn): https://kukuruku.co/post/the-nth-fibonacci-number-in-olog-n/

 */
class fibonacci {
    static int fib(int n) {
        int F[][] = new int[][]{{1, 1}, {1, 0}};
        if (n == 0) {
            return 0;
        }
        power(F, n -1);
        return F[0][0];
    }

    static void multiply(int F[][], int M[][]) {
        int x = F[0][0] * M[0][0] + F[0][1] * M[1][0];         
        int y = F[0][0] * M[0][1] + F[0][1] * M[1][1];         
        int z = F[1][0] * M[0][0] + F[1][1] * M[1][0];         
        int w = F[1][0] * M[0][1] + F[1][1] * M[1][1];         

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    static void power(int F[][], int n) {
        int M[][] = new int[][]{{1, 1}, {1, 0}};

        for (int i = 2; i <= n; i++) {
            multiply(F, M);
        }
    }

    public static void main (String args[]) {
        int n = 9;
        System.out.println(fib(n));
    }

}