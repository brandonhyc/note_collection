package codingPad;

public class Pad {
    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.splitPrimes("53739"));

        System.out.println(1.0 > 0);
        System.out.println(isPrime(739));

    }
//    0 1 2 3 4
//    5 3 7 3 9
//
//    5,3,7,3,x 0
//    5,3,7,x,  0
//    5,3,739   1
//    5,37, x   0
//    5,373,x   0
//    5,3739    1
//    53,739    1
//    53739

    private static boolean isPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
