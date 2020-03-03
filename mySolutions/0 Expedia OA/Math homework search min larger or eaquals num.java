// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,5};
        int key = 3;
        int target = arr[0] + key;
        if (arr[arr.length - 1] < target) System.out.printf("all \n"); // impossible to find
        else if (arr.length == 0) System.out.printf("arr.length == 0 \n");
        else {
            int found = serach(arr, target);
            System.out.printf("res: %d\n", 1 + (found + 1) / 2);
        }
    }
    
    
    static private int serach(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == target) r = m - 1;
            if (arr[m] < target) l = m + 1;
            else if (arr[m] > target) r = m - 1;
        }
                
        return l;
    }
}