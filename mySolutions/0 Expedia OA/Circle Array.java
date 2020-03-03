// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[] {1,3,2,3};
        int m = 4;
        int n = 3;
        
        System.out.println(circleArray(arr, m, n));
        arr = new int[] {1,5,10,5};
        m = 4;
        n = 10;
        System.out.println(circleArray(arr, m, n));
        
    }
    
    static private int circleArray(int[] arr, int m, int n) {
        // nodes # is 1,2,3,4 n is the largest, m connections
        
        int[] counts = new int[n + 1];
        for (int i = 0; i < m - 1; i++) {
            int f = arr[i];
            int t = arr[i + 1];
            for (int j = f; j != t; j += 1) {
                if (j == n + 1) j = 1;
                counts[j] += 1;
            }
            counts[t] += 1; // increment last node
        }
        int maxIndex = 1;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > counts[maxIndex]) maxIndex = i;
        }
        
        return maxIndex;
    }
    
    
}