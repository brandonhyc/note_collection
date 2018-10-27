public class Solution {
    /**
     * @param n: an integer
     * @return: return a string
     */


public String lastFourDigitsOfFn(int n) {
    
    int[][] f = {{1, 0}, {0, 0}};

    if (n == 0) return "0";

    power(f, n-1);

    String s = "" + f[0][0];

    while (s.length() < 4) {
        s = "0" + s;  
    }

    return s;
}

private static void power(int[][] f, int n) {
    int[][] m = {{1, 1}, {1, 0}};

    if (n == 1 || n == 2) return;

    power(f, n/ 2);
    multiply(f, f, 10000);

    if (n %2 == 0) return;

    multiply(f, m, 10000);
    return;
}

private static void multiply(int[][] f1, int[][] f2, int n) {
    
    int x = (f1[0][0]*f2[0][0]%n + f1[0][1]*f2[1][0]%n) %n;
    int y = (f1[0][0]*f2[0][1]%n + f1[0][1]*f2[1][1]%n) %n;
    int p = (f1[1][0]*f2[0][0]%n + f1[1][1]*f2[1][0]%n) %n;
    int q = (f1[1][0]*f2[0][1]%n + f1[1][1]*f2[1][1]%n) %n;

    f1[0][0] = x;
    f1[0][1] = y;
    f1[1][0] = p;
    f1[1][1] = q;

    return;
}
}

