//https://leetcode.com/discuss/interview-question/364760/
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,3};
        int[] arr2 = new int[]{2,3,1,4};
        System.out.printf("%d\n", maxRank(arr1, arr2, 4));
    }
    
    static private int maxRank(int[] A, int[] B, int n) {
        int[] in = new int[n + 1]; // 1 - n
        for (int i = 0; i < A.length; i++) {
            in[A[i]] += 1;
            in[B[i]] += 1;
        }
        int max = 0;
        System.out.printf("in: %s, \n", Arrays.toString(in));
        for (int i = 0; i < A.length; i++) {
            int rank = in[A[i]] + in[B[i]] - 1;
            max = Math.max(max, rank);
        }
        
        return max;
    }
    
}